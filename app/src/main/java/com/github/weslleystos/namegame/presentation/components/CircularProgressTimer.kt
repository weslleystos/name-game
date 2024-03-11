package com.github.weslleystos.namegame.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.Timer
import java.util.TimerTask

@Composable
fun CircularProgressTimer(
    totalTime: Int,
    onTimeUp: () -> Unit,
) {
    var currentTime by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        val timer = Timer()
        val timerTask = object : TimerTask() {
            override fun run() {
                if (currentTime < totalTime) {
                    currentTime++
                } else {
                    timer.cancel()
                    onTimeUp()
                }
            }
        }
        timer.schedule(timerTask, 0, 500)
    }

    CircularProgressIndicator(
        modifier = Modifier.padding(8.dp),
        progress = {  currentTime.toFloat() / totalTime },
        color = Color.White,
        strokeWidth = 5.dp,
    )
}