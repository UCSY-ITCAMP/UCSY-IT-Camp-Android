package co.rinda.ucsyitcamp.adapters

import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.rinda.ucsyitcamp.R
import co.rinda.ucsyitcamp.vos.ScheduleVO
import kotlinx.android.synthetic.main.list_item_schedule.view.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ScheduleListAdapter : RecyclerView.Adapter<ScheduleListAdapter.ScheduleViewHolder>() {

    var list: List<ScheduleVO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setNewData(list: List<ScheduleVO>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(scheduleVO: ScheduleVO) {

            val parser = SimpleDateFormat("h:mm a")

            try {

                val userDate = parser.format(Calendar.getInstance().time)

                if (getMillis(scheduleVO.from) <= getMillis(userDate) && getMillis(scheduleVO.to) >= getMillis(userDate)) {

                    itemView.tv_start_time.background = itemView.context.getDrawable(R.drawable.buttom_background)
                    itemView.tv_end_time.background = itemView.context.getDrawable(R.drawable.buttom_background)
                    itemView.tv_start_time.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))
                    itemView.tv_end_time.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))

                }

            } catch (e: ParseException) {
                // Invalid date was entered
            }

            itemView.tv_start_time.text = scheduleVO.from

            itemView.tv_end_time.text = scheduleVO.to

            val adapter = SpeakerListAdapter()
            val snapHelper = LinearSnapHelper()
            itemView.rv_speaker.setHasFixedSize(true)
            itemView.rv_speaker.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            itemView.rv_speaker.onFlingListener = null
            snapHelper.attachToRecyclerView(itemView.rv_speaker)
            itemView.rv_speaker.adapter = adapter
            adapter.setNewData(scheduleVO.rooms)


        }

        private fun getMillis(givenTime: String): Long {
            val sdf = SimpleDateFormat("h:mm a")
            try {
                val mDate = sdf.parse(givenTime)
                val timeInMilliseconds = mDate.getTime()
                return timeInMilliseconds;
            } catch (e: ParseException) {
                e.printStackTrace();
            }
            return 0

        }

    }

}