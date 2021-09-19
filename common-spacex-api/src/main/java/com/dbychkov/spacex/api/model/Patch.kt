package com.dbychkov.spacex.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Patch(
    @Json(name = "small") val small: String?,
    @Json(name = "large") val large: String?
)
