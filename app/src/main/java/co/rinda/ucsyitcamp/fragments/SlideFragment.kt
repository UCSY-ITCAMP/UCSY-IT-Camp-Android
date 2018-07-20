package co.rinda.ucsyitcamp.fragments


import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.rinda.ucsyitcamp.R
import co.rinda.ucsyitcamp.adapters.SlideListAdapter
import co.rinda.ucsyitcamp.delegates.SlideListActionDelegate
import co.rinda.ucsyitcamp.models.SlideModel
import kotlinx.android.synthetic.main.fragment_slide.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class SlideFragment : Fragment() {

    private lateinit var mAdapter: SlideListAdapter

    private lateinit var slideListActionDelegate: SlideListActionDelegate

    companion object {

        fun newInstance() : SlideFragment {
            return SlideFragment()
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        slideListActionDelegate = context as SlideListActionDelegate
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_slide, container, false)

        mAdapter = SlideListAdapter(slideListActionDelegate)
        view.rv_slide.setHasFixedSize(true)
        view.rv_slide.layoutManager = LinearLayoutManager(context)
        view.rv_slide.adapter = mAdapter

        SlideModel.loadSlides().observe(this, Observer {
            mAdapter.setNewData(it!!)
        })

        return view

    }


}
