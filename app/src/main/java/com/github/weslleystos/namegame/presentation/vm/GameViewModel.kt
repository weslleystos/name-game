package com.github.weslleystos.namegame.presentation.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.weslleystos.namegame.domain.usecase.GetProfilesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getProfilesUseCase: GetProfilesUseCase,
) : ViewModel() {

    init {
        viewModelScope.launch {
            val profiles = getProfilesUseCase()
            Log.d(this.javaClass.name, profiles.toString())
        }
    }
}