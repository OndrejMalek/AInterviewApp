package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Thumbnail (
    @SerializedName("ext")
    @Expose
    val ext: String = "",

    @SerializedName("url")
    @Expose
    val url: String = "",

    @SerializedName("hash")
    @Expose
    val hash: String = "",

    @SerializedName("mime")
    @Expose
    val mime: String = "",

    @SerializedName("name")
    @Expose
    val name: String = "",

    @SerializedName("size")
    @Expose
    val size: Float? = null,

    @SerializedName("width")
    @Expose
    val width: Float? = null,

    @SerializedName("height")
    @Expose
    val height: Float? = null,
)