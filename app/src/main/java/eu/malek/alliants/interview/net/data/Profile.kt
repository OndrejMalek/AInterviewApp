package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Profile (
    @SerializedName("id")
    @Expose
    val id: Float? = null,

    @SerializedName("title")
    @Expose
    val title: String = "",

    @SerializedName("subtitle")
    @Expose
    val subtitle: String = "",

    @SerializedName("description")
    @Expose
    val description: String = "",

    @SerializedName("image")
    @Expose
    val image: Image? = null,
)