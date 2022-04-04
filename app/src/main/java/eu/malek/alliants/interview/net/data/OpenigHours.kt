package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class OpenigHours (
    @SerializedName("id")
    @Expose
    val id: Long? = null,

    @SerializedName("monday")
    @Expose
    val monday: List<DayOfWeekOpening>? = null,

    @SerializedName("tuesday")
    @Expose
    val tuesday: List<DayOfWeekOpening>? = null,

    @SerializedName("wednesday")
    @Expose
    val wednesday: List<DayOfWeekOpening>? = null,

    @SerializedName("thursday")
    @Expose
    val thursday: List<DayOfWeekOpening>? = null,

    @SerializedName("friday")
    @Expose
    val friday: List<DayOfWeekOpening>? = null,

    @SerializedName("saturday")
    @Expose
    val saturday: List<DayOfWeekOpening>? = null,

    @SerializedName("sunday")
    @Expose
    val sunday: List<DayOfWeekOpening>? = null,


){
    fun getDaysOfWeek(): List<List<DayOfWeekOpening>?> {
        return listOf(monday,tuesday,wednesday,thursday,friday,saturday,sunday)
    }


}