package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Image (
    @SerializedName("id")
    @Expose
    val id: Float? = null,

    @SerializedName("name")
    @Expose
    val name: String = "",

    @SerializedName("alternativeText")
    @Expose
    val alternativeText: String = "",

    @SerializedName("caption")
    @Expose
    val caption: String = "",

    @SerializedName("width")
    @Expose
    val width: Float? = null,

    @SerializedName("height")
    @Expose
    val height: Float? = null,

    @SerializedName("formats")
    @Expose
    val formats: Formats? = null,

    @SerializedName("hash")
    @Expose
    val hash: String = "",

    @SerializedName("ext")
    @Expose
    val ext: String = "",

    @SerializedName("mime")
    @Expose
    val mime: String = "",

    @SerializedName("size")
    @Expose
    val size: Float? = null,

    @SerializedName("url")
    @Expose
    val url: String = "",

    @SerializedName("provider")
    @Expose
    val provider: String = "",

    @SerializedName("created_at")
    @Expose
    val createdAt: String = "",

    @SerializedName("updated_at")
    @Expose
    val updatedAt: String = "",
)