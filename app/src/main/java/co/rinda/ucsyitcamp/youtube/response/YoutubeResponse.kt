package co.rinda.ucsyitcamp.youtube.response

import com.google.gson.annotations.SerializedName

/**
 * Created by winthanhtike on 9/27/17.
 */

class YoutubeResponse<T> {

    @SerializedName("kind")
    val kind: String? = null

    @SerializedName("etag")
    val etag: String? = null

    @SerializedName("pageInfo")
    val pageInfo: PageInfoVO? = null

    @SerializedName("items")
    val youtubePlaylistVOList: List<T>? = null
}
