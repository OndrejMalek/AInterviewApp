package eu.malek.gson

import com.google.common.truth.Truth.assertThat
import com.google.gson.GsonBuilder
import org.junit.Test
import java.time.ZoneId


class ZoneIdDeserializerTest{

    @Test
    fun deserialize() {
        val gson = GsonBuilder()
            .registerTypeAdapter(ZoneId::class.java, ZoneIdDeserializer())
            .create()

        assertThat(
            gson.fromJson("""{zoneId="Europe/London"}""",TestObj::class.java)).isEqualTo(TestObj(ZoneId.of("Europe/London")))
        assertThat(
            gson.fromJson("""{zoneId=null}""",TestObj::class.java)).isEqualTo(TestObj(null))

        assertThat(
            gson.fromJson("""{zoneId=malformedddddd}""",TestObj::class.java)).isEqualTo(TestObj(DEFAULT_ZONE_ID))
    }

    data class TestObj(val zoneId : ZoneId?)
}