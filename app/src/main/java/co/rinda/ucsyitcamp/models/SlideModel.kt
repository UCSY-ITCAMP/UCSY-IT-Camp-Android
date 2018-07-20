package co.rinda.ucsyitcamp.models

import android.arch.lifecycle.MutableLiveData
import co.rinda.ucsyitcamp.vos.SlideVO
import com.google.firebase.database.*
import java.util.*

object SlideModel {

    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var mSlideDR: DatabaseReference

    private var slideListLiveData: MutableLiveData<List<SlideVO>> = MutableLiveData()

    init {
        mDatabaseReference = FirebaseDatabase.getInstance().reference
        mSlideDR = mDatabaseReference.child("2018").child("slides")
    }

    fun loadSlides() : MutableLiveData<List<SlideVO>> {

        mSlideDR.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val slideList = ArrayList<SlideVO>()
                for (snapshot in dataSnapshot.getChildren()) {
                    val slideVO = snapshot.getValue(SlideVO::class.java)!!
                    slideList.add(slideVO)
                }

                slideListLiveData.postValue(slideList)

            }

            override fun onCancelled(p0: DatabaseError) {

            }

        })

        return slideListLiveData

    }

}