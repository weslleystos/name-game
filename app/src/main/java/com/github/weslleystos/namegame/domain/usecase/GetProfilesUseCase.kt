package com.github.weslleystos.namegame.domain.usecase

import com.github.weslleystos.namegame.domain.model.Profile
import com.github.weslleystos.namegame.domain.repository.ProfileRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetProfilesUseCase @Inject constructor(private val profileRepository: ProfileRepository) {
    suspend operator fun invoke(): List<Profile> {
        return profileRepository.getProfiles()
    }
}