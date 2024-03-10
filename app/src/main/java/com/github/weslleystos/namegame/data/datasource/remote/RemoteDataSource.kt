package com.github.weslleystos.namegame.data.datasource.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val profileApi: ProfileApi) {
    suspend fun getProfiles() = profileApi.getProfiles()
}