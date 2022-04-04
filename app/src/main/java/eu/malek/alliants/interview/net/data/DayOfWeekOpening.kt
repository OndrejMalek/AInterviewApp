package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalTime

@Keep
data class DayOfWeekOpening(
    @SerializedName("closes_late")
    @Expose
    var closesLate: Boolean? = null,
    @SerializedName("closes_at")
    @Expose
    var closesAt: LocalTime? = null,
    @SerializedName("opens_at")
    @Expose
    var opensAt: LocalTime? = null,
    @SerializedName("id")
    @Expose
    var id: Long? = null
) {

}
