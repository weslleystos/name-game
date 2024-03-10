package com.github.weslleystos.namegame.data.repository

import com.github.weslleystos.namegame.data.datasource.remote.RemoteDataSource
import com.github.weslleystos.namegame.domain.model.Profile
import com.github.weslleystos.namegame.domain.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : ProfileRepository {
    override suspend fun getProfiles(): List<Profile> = withContext(Dispatchers.IO) {
        remoteDataSource.getProfiles()
    }
}