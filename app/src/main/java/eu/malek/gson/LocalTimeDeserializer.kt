package eu.malek.gson

import androidx.annotation.Keep
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.time.LocalTime
import java.time.format.DateTimeParseException

/**
 * serialize format: 2022-01-26T16:25:00+01:00
 */
@Keep
class LocalTimeDeserializer : JsonDeserializer<LocalTime> {


    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LocalTime {
        val jsonString: String = try {
            json.asJsonPrimitive.asString
        } catch (e: IllegalStateException) {
            throw JsonParseException(e)
        }

        return try {
            LocalTime.parse(jsonString)
        } catch (e: DateTimeParseException) {
            throw JsonParseException(e)
        }
    }
}