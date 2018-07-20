package co.rinda.ucsyitcamp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.rinda.ucsyitcamp.R
import co.rinda.ucsyitcamp.vos.RoomVO
import kotlinx.android.synthetic.main.list_item_speaker.view.*

class SpeakerListAdapter : RecyclerView.Adapter<SpeakerListAdapter.SpeakerViewHolder>() {

    var list: List<RoomVO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_speaker, parent, false)
        return SpeakerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setNewData(list: List<RoomVO>) {
        this.list = list
        notifyDataSetChanged()
    }

    class SpeakerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(roomVO: RoomVO) {

            itemView.tv_speaker_name.text = roomVO.speaker.name
            itemView.tv_topic_name.text = roomVO.speaker.topic
            itemView.tv_room.text = "Room - ${roomVO.id}"

        }

    }

}