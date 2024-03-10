package com.github.weslleystos.namegame.data.datasource.remote

import com.github.weslleystos.namegame.domain.model.Headshot
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeadshotResponse(
    @Json(name = "alt")
    override val alt: String,

    @Json(name = "height")
    override val height: Int? =  null,

    @Json(name = "id")
    override val id: String,

    @Json(name = "mimeType")
    override val mimeType: String? = null,

    @Json(name = "type")
    override val type: String,

    @Json(name = "url")
    override val url: String? = null,

    @Json(name = "width")
    override val width: Int? = null,
) : Headshot(alt, height, id, mimeType, type, url, width)