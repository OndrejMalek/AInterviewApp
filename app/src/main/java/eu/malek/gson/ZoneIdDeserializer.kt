package eu.malek.gson

import androidx.annotation.Keep
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.time.DateTimeException
import java.time.ZoneId



/**
 * deserialize format: "Europe/London"
 */
@Keep
class ZoneIdDeserializer(val defaultZoneId: ZoneId) : JsonDeserializer<ZoneId> {


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
            return defaultZoneId
        }
    }
}