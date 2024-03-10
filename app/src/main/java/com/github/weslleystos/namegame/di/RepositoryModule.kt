package com.github.weslleystos.namegame.di

import com.github.weslleystos.namegame.data.datasource.remote.RemoteDataSource
import com.github.weslleystos.namegame.data.repository.ProfileRepositoryImpl
import com.github.weslleystos.namegame.domain.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesProfileRepository(remoteDataSource: RemoteDataSource): ProfileRepository {
        return ProfileRepositoryImpl(remoteDataSource)
    }
}