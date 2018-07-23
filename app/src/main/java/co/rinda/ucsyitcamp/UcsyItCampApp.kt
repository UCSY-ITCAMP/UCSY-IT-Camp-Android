package co.rinda.ucsyitcamp

import android.app.Application
import com.google.firebase.database.FirebaseDatabase

class UcsyItCampApp : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseDatabase.getInstance().setPersistenceEnabled(true)

    }

}