package eu.malek.alliants.interview.net.data

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
class Vendor(
    @SerializedName("id")
    @Expose
    var id: Float? = null,

    @SerializedName("display_name")
    @Expose
    var displayName: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("timezone")
    @Expose
    var timezone: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null,

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null,

    @SerializedName("published_at")
    @Expose
    var publishedAt: String? = null,

    @SerializedName("opening_hours")
    @Expose
    var openingHours: OpenigHours? = null,

    @SerializedName("locale")
    @Expose
    var locale: String? = null,

    @SerializedName("contact_info")
    @Expose
    var contactInfo: ContactInfo? = null,

    @SerializedName("gallery")
    @Expose
    var gallery: List<Any>? = null,

    @SerializedName("information_sections")
    @Expose
    var informationSections: List<Any>? = null,

    @SerializedName("prices")
    @Expose
    var prices: List<Any>? = null,

    @SerializedName("meet_the")
    @Expose
    var meetThe: MeetThe? = null,
)