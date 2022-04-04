package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.ZoneId

private val DEFAULT_TIME_ZONE_ID = ZoneId.of("Europe/London")

@Keep
class Vendor(
    @SerializedName("id")
    @Expose
    val id: Float? = null,

    @SerializedName("display_name")
    @Expose
    val displayName: String = "",

    @SerializedName("name")
    @Expose
    val name: String = "",

    @SerializedName("timezone")
    @Expose
    val timezone: ZoneId? = DEFAULT_TIME_ZONE_ID,

    @SerializedName("description")
    @Expose
    val description: String = "",

    @SerializedName("created_at")
    @Expose
    val createdAt: String = "",

    @SerializedName("updated_at")
    @Expose
    val updatedAt: String = "",

    @SerializedName("published_at")
    @Expose
    val publishedAt: String = "",

    @SerializedName("opening_hours")
    @Expose
    val openingHours: OpenigHours? = null,

    @SerializedName("locale")
    @Expose
    val locale: String = "",

    @SerializedName("contact_info")
    @Expose
    val contactInfo: ContactInfo? = null,

    @SerializedName("gallery")
    @Expose
    val gallery: List<Any>? = null,

    @SerializedName("information_sections")
    @Expose
    val informationSections: List<Any>? = null,

    @SerializedName("prices")
    @Expose
    val prices: List<Any>? = null,

    @SerializedName("meet_the")
    @Expose
    val meetThe: MeetThe? = null,
){

}

