package com.dbychkov.spacex.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Flickr(
    @Json(name = "small") val small: List<String>,
    @Json(name = "original") val original: List<String>
)
