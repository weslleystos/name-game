package com.github.weslleystos.namegame.data.datasource.remote

import com.github.weslleystos.namegame.domain.model.Profile
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileResponse(
    @Json(name = "bio")
    override val bio: String? = null,

    @Json(name = "firstName")
    override val firstName: String,

    @Json(name = "headshot")
    override val headshot: HeadshotResponse,

    @Json(name = "id")
    override val id: String,

    @Json(name = "jobTitle")
    override val jobTitle: String? = null,

    @Json(name = "lastName")
    override val lastName: String,

    @Json(name = "slug")
    override val slug: String,

    @Json(name = "socialLinks")
    override val socialLinks: List<SocialLinkResponse>? = null,

    @Json(name = "type")
    override val type: String,
) : Profile(bio, firstName, headshot, id, jobTitle, lastName, slug, socialLinks, type)
