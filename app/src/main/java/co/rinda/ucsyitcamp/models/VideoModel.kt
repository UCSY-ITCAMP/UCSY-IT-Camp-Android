package co.rinda.ucsyitcamp.models

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import co.rinda.ucsyitcamp.utils.AppConstants
import co.rinda.ucsyitcamp.youtube.YoutubeService
import co.rinda.ucsyitcamp.youtube.response.YoutubePlaylistItemVO
import co.rinda.ucsyitcamp.youtube.response.YoutubeResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object VideoModel {

    private val mService: YoutubeService

    private var videoListLiveData: MutableLiveData<List<YoutubePlaylistItemVO>> = MutableLiveData()

    init {

        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.YOUTUBE_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        mService = retrofit.create(YoutubeService::class.java)

    }

    fun loadPlaylistItem(context: Context, playlistId: String) : MutableLiveData<List<YoutubePlaylistItemVO>> {

        val call = mService.loadPlaylistItem("snippet", playlistId, "AIzaSyCjHrw4fu-2r1lqWPCPK1-sKI07e7TzhoA")
        call.enqueue(object : Callback<YoutubeResponse<YoutubePlaylistItemVO>> {
            override fun onResponse(call: Call<YoutubeResponse<YoutubePlaylistItemVO>>, response: Response<YoutubeResponse<YoutubePlaylistItemVO>>) {

                val youtubeResponse = response.body()

                if (youtubeResponse != null) {
                    videoListLiveData.postValue(youtubeResponse.youtubePlaylistVOList)
                } else {

                }

            }

            override fun onFailure(call: Call<YoutubeResponse<YoutubePlaylistItemVO>>, t: Throwable) {

            }
        })

        return videoListLiveData

    }

}