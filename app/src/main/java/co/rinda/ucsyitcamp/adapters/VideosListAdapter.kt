package co.rinda.ucsyitcamp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.rinda.ucsyitcamp.R
import co.rinda.ucsyitcamp.delegates.VideoListActionDelegate
import co.rinda.ucsyitcamp.youtube.response.YoutubePlaylistItemVO
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_videos.view.*

class VideosListAdapter(private val videoListActionDelegate: VideoListActionDelegate) : RecyclerView.Adapter<VideosListAdapter.VideoViewHolder>() {

    private var list: List<YoutubePlaylistItemVO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_videos, parent, false)
        return VideoViewHolder(view, videoListActionDelegate)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setNewData(list: List<YoutubePlaylistItemVO>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class VideoViewHolder(itemView: View, private val videoListActionDelegate: VideoListActionDelegate) : RecyclerView.ViewHolder(itemView) {

        private lateinit var youtubePlaylistItemVO: YoutubePlaylistItemVO

        init {

            itemView.setOnClickListener {
                videoListActionDelegate.onTapPlay(youtubePlaylistItemVO.snippet?.resourceId?.videoId!!)
            }

        }

        fun bind(youtubePlaylistItemVO: YoutubePlaylistItemVO) {

            this.youtubePlaylistItemVO = youtubePlaylistItemVO

            itemView.tv_topic.text = youtubePlaylistItemVO.snippet?.title
            Glide.with(itemView.context)
                    .load(youtubePlaylistItemVO.snippet?.thumbnail?.defaultVO?.url)
                    .into(itemView.ivVideo)


        }

    }

}