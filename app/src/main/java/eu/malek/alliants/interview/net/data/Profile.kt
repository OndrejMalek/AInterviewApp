package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Profile (
    @SerializedName("id")
    @Expose
    var id: Float? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("subtitle")
    @Expose
    var subtitle: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("image")
    @Expose
    var image: Image? = null,
)