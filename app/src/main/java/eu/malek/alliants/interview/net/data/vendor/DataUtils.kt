package eu.malek.alliants.interview.net.data.vendor

import java.time.LocalTime
import java.time.ZonedDateTime

enum class IsOpen{
    UNKNOWN, OPEN, CLOSE
}

fun isVendorOpenNow(vendor: Vendor): IsOpen {
    return isVendorOpen(vendor, ZonedDateTime.now(vendor.timezone ?: DEFAULT_TIME_ZONE_ID))
}

fun isVendorOpen(
    vendor: Vendor,
    zonedDateTime: ZonedDateTime,
): IsOpen {
    return if (vendor.openingHours?.getDaysOfWeek() == null) {
        IsOpen.UNKNOWN //TODO what if there is no time ?,  Missing timezone?
    } else {

        vendor.openingHours.getDaysOfWeek().get(zonedDateTime.dayOfWeek.value - 1)
            .let { openingsInDay ->
                if (openingsInDay != null) {
                    isOpeningHoursOpened(openingsInDay, zonedDateTime)
                } else {
                    IsOpen.UNKNOWN
                }
            }

    }
}

fun isOpeningHoursOpened(
    openingsInDay: List<DayOfWeekOpening>,
    now: ZonedDateTime
): IsOpen {
    return openingsInDay
        .any { openingInDay ->
            //TODO sometimes time is missing
            if (openingInDay.closesAt != null && openingInDay.opensAt != null) {
                isOpeningHoursOpened(openingInDay, now)
            } else {
                false
            }
        }
        .let { isOpen ->
            if (isOpen) {
                IsOpen.OPEN
            } else {
                IsOpen.CLOSE
            }
        }
}

fun isOpeningHoursOpened(
    openingInDay: DayOfWeekOpening,
    time: ZonedDateTime
): Boolean {
    val opensAt = toZoneDateTimeWithLocalTime(time, openingInDay.opensAt!!)
    val closesAt = toZoneDateTimeWithLocalTime(time, openingInDay.closesAt!!)

    return time.isAfter(opensAt) && time.isBefore(closesAt)
}

fun toZoneDateTimeWithLocalTime(
    zoneTime: ZonedDateTime,
    localTime: LocalTime
) =
    zoneTime
    .withHour(localTime.hour)
    .withMinute(localTime.minute)
    .withSecond(localTime.second)