package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Image (
    @SerializedName("id")
    @Expose
    var id: Float? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("alternativeText")
    @Expose
    var alternativeText: String? = null,

    @SerializedName("caption")
    @Expose
    var caption: String? = null,

    @SerializedName("width")
    @Expose
    var width: Float? = null,

    @SerializedName("height")
    @Expose
    var height: Float? = null,

    @SerializedName("formats")
    @Expose
    var formats: Formats? = null,

    @SerializedName("hash")
    @Expose
    var hash: String? = null,

    @SerializedName("ext")
    @Expose
    var ext: String? = null,

    @SerializedName("mime")
    @Expose
    var mime: String? = null,

    @SerializedName("size")
    @Expose
    var size: Float? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("provider")
    @Expose
    var provider: String? = null,

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null,

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null,
)