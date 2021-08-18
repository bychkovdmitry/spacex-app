package com.dbychkov.spacex.api.model.dto

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
    @Json(name = "fairings") val fairings: FairingsDto?,
    @Json(name = "crew") val crewIDs: List<String>,
    @Json(name = "ships") val shipIDs: List<String>,
    @Json(name = "capsules") val capsuleIDs: List<String>,
    @Json(name = "payloads") val payloadIDs: List<String>,
    @Json(name = "launchpad") val launchpadID: String?,
    @Json(name = "cores") val cores: List<CoreDto>,
    @Json(name = "links") val links: LinksDto?,
    @Json(name = "auto_update") val autoUpdate: Boolean?
)

@JsonClass(generateAdapter = true)
data class FairingsDto(
    @Json(name = "reused") val reused: Boolean?,
    @Json(name = "recovery_attempt") val recoveryAttempted: Boolean?,
    @Json(name = "recovered") val recovered: Boolean?,
    @Json(name = "ships") val shipIDs: List<String>
)

@JsonClass(generateAdapter = true)
data class CoreDto(
    @Json(name = "core") val id: String?,
    @Json(name = "flight") val flight: Int?,
    @Json(name = "gridfins") val gridfins: Boolean?,
    @Json(name = "legs") val legs: Boolean?,
    @Json(name = "reused") val reused: Boolean?,
    @Json(name = "landing_attempt") val landingAttempt: Boolean?,
    @Json(name = "landing_success") val landingSuccess: Boolean?,
    @Json(name = "landing_type") val landingType: String?,
    @Json(name = "landpad") val landpadID: String?
)

@JsonClass(generateAdapter = true)
data class LinksDto(
    @Json(name = "patch") val patch: PatchDto?,
    @Json(name = "reddit") val reddit: RedditDto?,
    @Json(name = "flickr") val flickr: FlickrDto?,
    @Json(name = "presskit") val presskit: String?,
    @Json(name = "webcast") val webcast: String?,
    @Json(name = "youtube_id") val youtubeID: String?,
    @Json(name = "article") val article: String?,
    @Json(name = "wikipedia") val wikipedia: String?
)

@JsonClass(generateAdapter = true)
data class PatchDto(
    @Json(name = "small") val small: String?,
    @Json(name = "large") val large: String?
)

@JsonClass(generateAdapter = true)
data class RedditDto(
    @Json(name = "campaign") val campaign: String?,
    @Json(name = "launch") val launch: String?,
    @Json(name = "media") val media: String?,
    @Json(name = "recovery") val recovery: String?
)

@JsonClass(generateAdapter = true)
data class FlickrDto(
    @Json(name = "small") val small: List<String>,
    @Json(name = "original") val original: List<String>
)
