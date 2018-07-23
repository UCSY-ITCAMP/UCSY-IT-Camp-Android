package co.rinda.ucsyitcamp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.rinda.ucsyitcamp.R
import co.rinda.ucsyitcamp.delegates.SlideListActionDelegate
import co.rinda.ucsyitcamp.vos.SlideVO
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_slide.view.*

class SlideListAdapter(private val slideListActionDelegate: SlideListActionDelegate) : RecyclerView.Adapter<SlideListAdapter.SlideViewHolder>() {

    var list: List<SlideVO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_slide, parent, false)
        return SlideViewHolder(view, slideListActionDelegate)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setNewData(list: List<SlideVO>) {
        this.list = list
        notifyDataSetChanged()
    }

    class SlideViewHolder(itemView: View, private val slideListActionDelegate: SlideListActionDelegate) : RecyclerView.ViewHolder(itemView) {

        fun bind(slideVO: SlideVO) {

            itemView.tv_slide_name.text = slideVO.topic
            itemView.tv_speaker_name.text = slideVO.speaker_name

            Glide.with(itemView.context)
                    .load(slideVO.speaker_profile_url)
                    .into(itemView.iv_speaker_profile)

            itemView.iv_download.setOnClickListener {
                slideListActionDelegate.onTapDownloadSlide(slideVO.url)
            }

        }

    }
}