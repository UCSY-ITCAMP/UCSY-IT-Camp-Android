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
import co.rinda.ucsyitcamp.adapters.VideosListAdapter
import co.rinda.ucsyitcamp.delegates.VideoListActionDelegate
import co.rinda.ucsyitcamp.models.VideoModel
import kotlinx.android.synthetic.main.fragment_videos.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class VideosFragment : Fragment() {

    private lateinit var mAdapter: VideosListAdapter

    private lateinit var videoListActionDelegate: VideoListActionDelegate

    companion object {

        fun newInstance() : VideosFragment {
            return VideosFragment()
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        videoListActionDelegate = context as VideoListActionDelegate
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_videos, container, false)

        mAdapter = VideosListAdapter(videoListActionDelegate)
        view.rv_videos.setHasFixedSize(true)
        view.rv_videos.layoutManager = LinearLayoutManager(context)
        view.rv_videos.adapter = mAdapter

        VideoModel.loadPlaylistItem(context!!, "PLWz5rJ2EKKc9mxIBd0DRw9gwXuQshgmn2").observe(this, Observer {

            mAdapter.setNewData(it!!)

        })

        return view

    }


}
