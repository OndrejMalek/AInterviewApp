package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class MeetThe(
    @SerializedName("id")
    @Expose
    var id: Float? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("profiles")
    @Expose
    var profiles: List<Profile>? = null,
)