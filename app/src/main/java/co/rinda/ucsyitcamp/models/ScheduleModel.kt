package co.rinda.ucsyitcamp.models

import android.arch.lifecycle.MutableLiveData
import co.rinda.ucsyitcamp.vos.ScheduleVO
import com.google.firebase.database.*
import java.util.*

object ScheduleModel {

    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var mScheduleDR: DatabaseReference

    private var scheduleListLiveData: MutableLiveData<List<ScheduleVO>> = MutableLiveData()

    init {
        mDatabaseReference = FirebaseDatabase.getInstance().reference
        mScheduleDR = mDatabaseReference.child("2018").child("schedules")
    }

    fun loadSchedule() : MutableLiveData<List<ScheduleVO>> {

        mScheduleDR.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val scheduleList = ArrayList<ScheduleVO>()
                for (snapshot in dataSnapshot.getChildren()) {
                    val scheduleVO = snapshot.getValue(ScheduleVO::class.java)!!
                    scheduleList.add(scheduleVO)
                }

                scheduleListLiveData.postValue(scheduleList)

            }

        })

        return scheduleListLiveData

    }

}