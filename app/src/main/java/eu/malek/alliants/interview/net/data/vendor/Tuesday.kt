package eu.malek.alliants.interview.net.data.vendor

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Tuesday (
    @SerializedName("id")
    @Expose
    val id: Long? = null,

    @SerializedName("opens_at")
    @Expose
    val opensAt: String = "",

    @SerializedName("closes_at")
    @Expose
    val closesAt: String = "",

    @SerializedName("closes_late")
    @Expose
    val closesLate: Boolean? = null,
)