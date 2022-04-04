package eu.malek.gson

import androidx.annotation.Keep
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.time.DateTimeException
import java.time.ZoneId


val DEFAULT_ZONE_ID: ZoneId = ZoneId.of("Europe/London")


/**
 * deserialize format: "Europe/London"
 */
@Keep
class ZoneIdDeserializer : JsonDeserializer<ZoneId> {


    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): ZoneId {
        val jsonString: String = try {
            json.asJsonPrimitive.asString
        } catch (e: IllegalStateException) {
            throw JsonParseException(e)
        }

        return try {
            ZoneId.of(jsonString)
        } catch (e: DateTimeException) {
            return DEFAULT_ZONE_ID
        }
    }
}