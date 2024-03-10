package com.github.weslleystos.namegame.domain.model

open class Profile(
    open val bio: String? = null,
    open val firstName: String,
    open val headshot: Headshot,
    open val id: String,
    open val jobTitle: String?,
    open val lastName: String,
    open val slug: String,
    open val socialLinks: List<SocialLink>? = null,
    open val type: String
)