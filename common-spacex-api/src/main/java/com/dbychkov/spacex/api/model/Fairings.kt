package com.dbychkov.spacex.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Fairings(
    @Json(name = "reused") val reused: Boolean?,
    @Json(name = "recovery_attempt") val recoveryAttempted: Boolean?,
    @Json(name = "recovered") val recovered: Boolean?,
    @Json(name = "ships") val shipIDs: List<String>
)
