package com.github.weslleystos.namegame.presentation.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.weslleystos.namegame.domain.usecase.GetProfilesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getProfilesUseCase: GetProfilesUseCase,
) : ViewModel() {

    private val _selected = MutableStateFlow(0)
    val selected = _selected.asStateFlow()

    init {
        viewModelScope.launch {
            val profiles = getProfilesUseCase()
            Log.d(this.javaClass.name, profiles.toString())
        }
    }

    fun setSelected(value: Int) {
        _selected.value = value
    }
}