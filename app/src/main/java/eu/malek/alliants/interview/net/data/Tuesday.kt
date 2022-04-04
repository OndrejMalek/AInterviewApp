package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Tuesday (
    @SerializedName("id")
    @Expose
    var id: Long? = null,

    @SerializedName("opens_at")
    @Expose
    var opensAt: String? = null,

    @SerializedName("closes_at")
    @Expose
    var closesAt: String? = null,

    @SerializedName("closes_late")
    @Expose
    var closesLate: Boolean? = null,
)