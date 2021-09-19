package com.dbychkov.spacex.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.ZonedDateTime

@JsonClass(generateAdapter = true)
data class Launch(
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
    @Json(name = "fairings") val fairings: Fairings?,
    @Json(name = "crew") val crewIDs: List<String>,
    @Json(name = "ships") val shipIDs: List<String>,
    @Json(name = "capsules") val capsuleIDs: List<String>,
    @Json(name = "payloads") val payloadIDs: List<String>,
    @Json(name = "launchpad") val launchpadID: String?,
    @Json(name = "cores") val cores: List<Core>,
    @Json(name = "links") val links: Links?,
    @Json(name = "auto_update") val autoUpdate: Boolean?
)
