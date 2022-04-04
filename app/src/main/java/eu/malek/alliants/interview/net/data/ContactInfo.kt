package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class ContactInfo(
    @SerializedName("id")
    @Expose
    var id: Float? = null,

    @SerializedName("website_url")
    @Expose
    var websiteUrl: String? = null,
)