package com.github.weslleystos.namegame.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.weslleystos.namegame.domain.model.Profile
import com.github.weslleystos.namegame.domain.usecase.GetProfilesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class GameViewModel @Inject constructor(
    private val getProfilesUseCase: GetProfilesUseCase,
) : ViewModel() {
    private val _profiles = MutableStateFlow(emptyList<Profile>())

    val profiles = _profiles.mapLatest { profiles ->
        profiles.shuffled().take(6)
   } 

    val selected = profiles.mapLatest { profiles ->
        profiles.shuffled().first()
    }

    init {
        viewModelScope.launch {
            _profiles.value = getProfilesUseCase()
            println()
        }
    }
}