package com.dbychkov.spacex.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "patch") val patch: Patch?,
    @Json(name = "reddit") val reddit: Reddit?,
    @Json(name = "flickr") val flickr: Flickr?,
    @Json(name = "presskit") val presskit: String?,
    @Json(name = "webcast") val webcast: String?,
    @Json(name = "youtube_id") val youtubeID: String?,
    @Json(name = "article") val article: String?,
    @Json(name = "wikipedia") val wikipedia: String?
)
