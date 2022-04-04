package eu.malek.gson

import com.google.common.truth.Truth.assertThat
import com.google.gson.GsonBuilder
import org.junit.Test
import java.time.LocalTime
import java.time.format.DateTimeParseException


class LocalTimeDeserializerTest{

    @Test
    fun deserialize() {
        val gson = GsonBuilder()
            .registerTypeAdapter(LocalTime::class.java, LocalTimeDeserializer())
            .create()

        assertThat(
            gson.fromJson("""{time="10:11:12"}""",TestObj::class.java)).isEqualTo(TestObj(LocalTime.of(10,11, 12)))
        assertThat(
            gson.fromJson("""{time=null}""",TestObj::class.java)).isEqualTo(TestObj(null))
    }

    @Test(expected = DateTimeParseException::class)
    fun deserialize_expectExceptionOnMalformedData() {
        val gson = GsonBuilder()
            .registerTypeAdapter(LocalTime::class.java, LocalTimeDeserializer())
            .create()


        gson.fromJson("""{time=nullsdaseee}""",TestObj::class.java)
    }

    data class TestObj(val time : LocalTime?)
}