package com.dbychkov.spacex.domain.model

import java.time.ZonedDateTime

data class Launch(
    val id: String,
    val flightNumber: Int,
    val name: String,
    val launchDateUTC: ZonedDateTime,
    val launchDateLocal: ZonedDateTime,
    val launchDateUnix: Long,
    val staticFireDateUTC: ZonedDateTime?,
    val staticFireDateUnix: Long?,
    val tbd: Boolean?,
    val net: Boolean?,
    val window: Int?,
    val rocketID: String?,
    val success: Boolean?,
    val upcoming: Boolean,
    val details: String?,
    val crewIDs: List<String>,
    val shipIDs: List<String>,
    val capsuleIDs: List<String>,
    val payloadIDs: List<String>,
    val launchpadID: String?,
    val autoUpdate: Boolean?
)
