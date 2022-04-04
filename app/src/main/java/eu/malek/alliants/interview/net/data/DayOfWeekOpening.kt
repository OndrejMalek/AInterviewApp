package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalTime

@Keep
data class DayOfWeekOpening(
    @SerializedName("closes_late")
    @Expose
    val closesLate: Boolean? = null,
    @SerializedName("closes_at")
    @Expose
    val closesAt: LocalTime? = null,
    @SerializedName("opens_at")
    @Expose
    val opensAt: LocalTime? = null,
    @SerializedName("id")
    @Expose
    val id: Long? = null
) {

}
