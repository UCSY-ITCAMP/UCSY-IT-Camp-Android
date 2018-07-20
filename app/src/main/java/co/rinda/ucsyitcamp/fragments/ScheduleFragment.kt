package co.rinda.ucsyitcamp.fragments


import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.rinda.ucsyitcamp.R
import co.rinda.ucsyitcamp.adapters.ScheduleListAdapter
import co.rinda.ucsyitcamp.models.ScheduleModel
import kotlinx.android.synthetic.main.fragment_schedule.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ScheduleFragment : Fragment() {

    private lateinit var mAdapter: ScheduleListAdapter

    private lateinit var progressDialog: ProgressDialog

    companion object {

        fun newInstance() : ScheduleFragment {
            return ScheduleFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_schedule, container, false)

        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Loading Data...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        ScheduleModel.loadSchedule().observe(this, Observer {

            if (it != null) {

                progressDialog.hide()
                mAdapter.setNewData(it)


            }

        })

        mAdapter = ScheduleListAdapter()
        view.rv_schedule.setHasFixedSize(true)
        view.rv_schedule.layoutManager = LinearLayoutManager(context)
        view.rv_schedule.adapter = mAdapter

        return view

    }


}
