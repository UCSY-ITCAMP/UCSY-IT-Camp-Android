package co.rinda.ucsyitcamp.youtube.response

import com.google.gson.annotations.SerializedName

/**
 * Created by winthanhtike on 9/28/17.
 */

class SnippetVO {

    @SerializedName("publishedAt")
    val publishedAt: String? = null

    @SerializedName("channelId")
    val channelId: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("thumbnails")
    val thumbnail: ThumbnailVO? = null

    @SerializedName("channelTitle")
    val channelTitle: String? = null

    @SerializedName("localized")
    val localized: LocalizedVO? = null

    @SerializedName("playlistId")
    val playlistId: String? = null

    @SerializedName("position")
    val position: Int = 0

    @SerializedName("resourceId")
    val resourceId: ResourceIdVO? = null
}
