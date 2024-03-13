package com.github.weslleystos.namegame.presentation.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.weslleystos.namegame.R
import com.github.weslleystos.namegame.domain.model.Profile
import com.github.weslleystos.namegame.presentation.components.CircularProgressTimer
import com.github.weslleystos.namegame.presentation.theme.BackgroundToolbar
import com.github.weslleystos.namegame.presentation.theme.NameGameTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    profiles: List<Profile>,
    selectedProfile: Profile? = null,
    onSelected: (Int) -> Unit,
    onBack: () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Practice Mode", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { onBack.invoke() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = stringResource(R.string.icon_arrow_back_description),
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    CircularProgressTimer(totalTime = 30) {

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundToolbar
                )
            )
        }
    ) { paddingValues ->
        val isPortraitMode =
            LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
        Column(modifier.padding(paddingValues)) {
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "${selectedProfile?.firstName} ${selectedProfile?.lastName}",
                textAlign = TextAlign.Center
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(if (isPortraitMode) 2 else 3)
            ) {
                items(6) { index ->
                    GlideImage(
                        modifier = modifier.size(144.dp),
                        model = "https://picsum.photos/50/50",
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GameScreenPreview() {
    NameGameTheme {
//        GameScreen(onSelected = {}, onBack = {})
    }
}