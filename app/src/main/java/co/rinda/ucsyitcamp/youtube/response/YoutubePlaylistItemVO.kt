package co.rinda.ucsyitcamp.youtube.response

import com.google.gson.annotations.SerializedName

/**
 * Created by winthanhtike on 9/28/17.
 */

class YoutubePlaylistItemVO {

    @SerializedName("kind")
    val kind: String? = null

    @SerializedName("etag")
    val etag: String? = null

    @SerializedName("id")
    val id: String? = null

    @SerializedName("snippet")
    val snippet: SnippetVO? = null

}
