package com.github.weslleystos.namegame.data.datasource.remote

import retrofit2.http.GET

interface ProfileApi {
    @GET("profiles")
    suspend fun getProfiles(): List<ProfileResponse>
}