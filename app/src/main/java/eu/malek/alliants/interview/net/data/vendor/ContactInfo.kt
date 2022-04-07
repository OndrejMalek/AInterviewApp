package eu.malek.alliants.interview.net.data.vendor

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class ContactInfo(
    @SerializedName("id")
    @Expose
    val id: Float? = null,

    @SerializedName("website_url")
    @Expose
    val websiteUrl: String = "",
)