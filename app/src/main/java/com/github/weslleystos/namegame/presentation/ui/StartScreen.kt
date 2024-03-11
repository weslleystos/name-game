package com.github.weslleystos.namegame.presentation.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.weslleystos.namegame.R
import com.github.weslleystos.namegame.presentation.components.StartBackground
import com.github.weslleystos.namegame.presentation.theme.BackgroundButton
import com.github.weslleystos.namegame.presentation.theme.NameGameTheme

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onPractice: () -> Unit,
    onTimed: () -> Unit,
) {
    val isPortraitMode =
        LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT

    StartBackground {
        val width = dimensionResource(id = R.dimen.start_screen_components_width)
        Column(
            modifier = modifier
                .fillMaxWidth(width.value)
                .padding(vertical = 24.dp)
                .align(
                    if (isPortraitMode) Alignment.BottomCenter else Alignment.CenterEnd
                )
        ) {
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                text = stringResource(R.string.start_screen_game_descritption),
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(8.dp))
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = BackgroundButton
                ),
                onClick = { onPractice.invoke() }
            ) {
                Text(text = stringResource(R.string.start_screen_practice_mode))
            }
            Spacer(modifier = modifier.height(8.dp))
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = BackgroundButton
                ),
                onClick = { onTimed.invoke() }
            ) {
                Text(text = stringResource(R.string.start_screen_timed_mode))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun StartScreenPreview() {
    NameGameTheme {
        StartScreen(onPractice = { /*TODO*/ }) {

        }
    }
}