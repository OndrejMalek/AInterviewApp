package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Thumbnail (
    @SerializedName("ext")
    @Expose
    var ext: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("hash")
    @Expose
    var hash: String? = null,

    @SerializedName("mime")
    @Expose
    var mime: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("size")
    @Expose
    var size: Float? = null,

    @SerializedName("width")
    @Expose
    var width: Float? = null,

    @SerializedName("height")
    @Expose
    var height: Float? = null,
)