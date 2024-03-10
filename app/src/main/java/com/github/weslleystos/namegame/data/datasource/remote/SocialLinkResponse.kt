package com.github.weslleystos.namegame.data.datasource.remote

import com.github.weslleystos.namegame.domain.model.SocialLink
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class SocialLinkResponse(
    @Json(name = "callToAction")
    override val callToAction: String,

    @Json(name = "type")
    override val type: String,

    @Json(name = "url")
    override val url: String,
) : SocialLink(callToAction, type, url)