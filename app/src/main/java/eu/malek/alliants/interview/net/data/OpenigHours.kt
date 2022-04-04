package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

@Keep
data class OpenigHours (
    @SerializedName("id")
    @Expose
    var id: Long? = null,

    @SerializedName("monday")
    @Expose
    var monday: List<DayOfWeekOpening>? = null,

    @SerializedName("tuesday")
    @Expose
    var tuesday: List<DayOfWeekOpening>? = null,

    @SerializedName("wednesday")
    @Expose
    var wednesday: List<DayOfWeekOpening>? = null,

    @SerializedName("thursday")
    @Expose
    var thursday: List<DayOfWeekOpening>? = null,

    @SerializedName("friday")
    @Expose
    var friday: List<DayOfWeekOpening>? = null,

    @SerializedName("saturday")
    @Expose
    var saturday: List<DayOfWeekOpening>? = null,

    @SerializedName("sunday")
    @Expose
    var sunday: List<DayOfWeekOpening>? = null,
)