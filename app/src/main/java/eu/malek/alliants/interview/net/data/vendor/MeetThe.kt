package eu.malek.alliants.interview.net.data.vendor

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class MeetThe(
    @SerializedName("id")
    @Expose
    val id: Float? = null,

    @SerializedName("title")
    @Expose
    val title: String = "",

    @SerializedName("profiles")
    @Expose
    val profiles: List<Profile>? = null,
)