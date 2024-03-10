package com.github.weslleystos.namegame.domain.repository

import com.github.weslleystos.namegame.domain.model.Profile

interface ProfileRepository {
    suspend fun getProfiles(): List<Profile>
}