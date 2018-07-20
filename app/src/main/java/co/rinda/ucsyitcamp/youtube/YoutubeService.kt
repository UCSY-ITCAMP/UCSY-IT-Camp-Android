package co.rinda.ucsyitcamp.youtube

import co.rinda.ucsyitcamp.youtube.response.YoutubePlaylistItemVO
import co.rinda.ucsyitcamp.youtube.response.YoutubePlaylistVO
import co.rinda.ucsyitcamp.youtube.response.YoutubeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by winthanhtike on 9/27/17.
 */

interface YoutubeService {

    @GET("youtube/v3/playlists")
    fun loadPlaylist(
            @Query("part") part: String,
            @Query("maxResults") maxResults: String,
            @Query("channelId") channelId: String,
            @Query("key") apiKey: String
    ): Call<YoutubeResponse<YoutubePlaylistVO>>

    @GET("youtube/v3/playlistItems")
    fun loadPlaylistItem(
            @Query("part") part: String,
            @Query("playlistId") playlistId: String,
            @Query("key") apiKey: String
    ): Call<YoutubeResponse<YoutubePlaylistItemVO>>

}
