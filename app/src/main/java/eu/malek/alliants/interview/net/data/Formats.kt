package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Formats (
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: Thumbnail? = null,
)