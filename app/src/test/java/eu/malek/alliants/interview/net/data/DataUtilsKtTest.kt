package eu.malek.alliants.interview.net.data

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime


class DataUtilsKtTest {

    @Test
    fun isVendorOpen() {
        val vendor = testVendor()



        assertThat(isVendorOpen(vendor, zonedMonday(vendor, 9, 11))).isEqualTo(IsOpen.OPEN)
        assertThat(isVendorOpen(vendor, zonedMonday(vendor, 9, 10))).isEqualTo(IsOpen.OPEN)
        assertThat(isVendorOpen(vendor, zonedMonday(vendor, 10, 10))).isEqualTo(IsOpen.CLOSE)
        assertThat(isVendorOpen(vendor, zonedMonday(vendor, 9, 9))).isEqualTo(IsOpen.CLOSE)
        assertThat(isVendorOpen(vendor, zonedMonday(vendor, 14, 30))).isEqualTo(IsOpen.OPEN)

        assertThat(isVendorOpen(vendor, zonedFriday(vendor, 14, 30))).isEqualTo(IsOpen.CLOSE)
    }

    private fun zonedMonday(vendor: Vendor, hours: Int, minutes: Int): ZonedDateTime {
        return ZonedDateTime.of(2022, 4, 4, hours, minutes, 12, 13, vendor.timezone)
    }

    private fun zonedFriday(vendor: Vendor, hours: Int, minutes: Int): ZonedDateTime {
        return ZonedDateTime.of(2022, 4, 8, hours, minutes, 12, 13, vendor.timezone)
    }

    private fun testVendor(): Vendor {
        return Vendor(
            timezone = ZoneId.of("Europe/London"),
            openingHours = OpenigHours(
                monday = listOf(
                    DayOfWeekOpening(
                        opensAt = LocalTime.of(9, 10),
                        closesAt = LocalTime.of(10, 10),
                    ),

                    DayOfWeekOpening(
                        opensAt = LocalTime.of(14, 10),
                        closesAt = LocalTime.of(15, 10),
                    )
                )
            )
        )
    }
}