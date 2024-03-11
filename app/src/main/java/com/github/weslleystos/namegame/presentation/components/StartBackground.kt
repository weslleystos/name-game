package com.github.weslleystos.namegame.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.github.weslleystos.namegame.R
import com.github.weslleystos.namegame.presentation.theme.PrimaryColor

@Composable
fun StartBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = PrimaryColor)
    ) {
        Image(
            modifier = Modifier.align(Alignment.CenterStart),
            painter = painterResource(id = R.drawable.background),
            contentDescription = stringResource(R.string.background_description)
        )
        content()
    }
}
