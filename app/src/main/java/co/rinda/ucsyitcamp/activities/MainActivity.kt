package co.rinda.ucsyitcamp.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import co.rinda.ucsyitcamp.R
import co.rinda.ucsyitcamp.delegates.SlideListActionDelegate
import co.rinda.ucsyitcamp.delegates.VideoListActionDelegate
import co.rinda.ucsyitcamp.fragments.ScheduleFragment
import co.rinda.ucsyitcamp.fragments.SlideFragment
import co.rinda.ucsyitcamp.fragments.VideosFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), VideoListActionDelegate, SlideListActionDelegate {
    override fun onTapDownloadSlide(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onTapPlay(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + url))
        startActivity(intent)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, ScheduleFragment.newInstance())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, VideosFragment.newInstance())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, SlideFragment.newInstance())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, ScheduleFragment.newInstance())
                    .commit()
        }

    }
}
