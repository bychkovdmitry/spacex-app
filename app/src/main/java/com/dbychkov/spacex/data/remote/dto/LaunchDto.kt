package com.dbychkov.spacex.data.remote.dto

import com.dbychkov.spacex.domain.model.Launch
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.ZonedDateTime

@JsonClass(generateAdapter = true)
data class LaunchDto(
    @Json(name = "id") val id: String,
    @Json(name = "flight_number") val flightNumber: Int,
    @Json(name = "name") val name: String,
    @Json(name = "date_utc") val launchDateUTC: ZonedDateTime,
    @Json(name = "date_local") val launchDateLocal: ZonedDateTime,
    @Json(name = "date_unix") val launchDateUnix: Long,
    @Json(name = "static_fire_date_utc") val staticFireDateUTC: ZonedDateTime?,
    @Json(name = "static_fire_date_unix") val staticFireDateUnix: Long?,
    @Json(name = "tdb") val tbd: Boolean?,
    @Json(name = "net") val net: Boolean?,
    @Json(name = "window") val window: Int?,
    @Json(name = "rocket") val rocketID: String?,
    @Json(name = "success") val success: Boolean?,
    @Json(name = "upcoming") val upcoming: Boolean,
    @Json(name = "details") val details: String?,
    @Json(name = "crew") val crewIDs: List<String>,
    @Json(name = "ships") val shipIDs: List<String>,
    @Json(name = "capsules") val capsuleIDs: List<String>,
    @Json(name = "payloads") val payloadIDs: List<String>,
    @Json(name = "launchpad") val launchpadID: String?,
    @Json(name = "auto_update") val autoUpdate: Boolean?
)

fun LaunchDto.toModel(): Launch {
    return Launch(
        id = id,
        flightNumber = flightNumber,
        name = name,
        launchDateUTC = launchDateUTC,
        launchDateLocal = launchDateLocal,
        launchDateUnix = launchDateUnix,
        staticFireDateUTC = staticFireDateUTC,
        staticFireDateUnix = staticFireDateUnix,
        tbd = tbd,
        net = net,
        window = window,
        rocketID = rocketID,
        success = success,
        upcoming = upcoming,
        details = details,
        crewIDs = crewIDs,
        shipIDs = shipIDs,
        capsuleIDs = capsuleIDs,
        payloadIDs = payloadIDs,
        launchpadID = launchpadID,
        autoUpdate = autoUpdate
    )
}
