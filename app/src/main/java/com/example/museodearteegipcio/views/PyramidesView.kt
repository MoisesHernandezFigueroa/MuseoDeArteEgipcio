package com.example.museodearteegipcio.views

import android.app.Activity
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.ui.PlayerView
import com.example.museodearteegipcio.MainActivity
import com.example.museodearteegipcio.R

val M3U8_URL = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"

@Composable
fun PyramidesView(activity: MainActivity) {
Column {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            VideoPlayerView(activity)
        }

    }
    VideoInformationView()
}
}


@OptIn(UnstableApi::class)
@Composable
fun VideoPlayerView(activity: MainActivity) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val exoPlayer = remember { ExoPlayerManager.getExoPlayer(context) }

    LaunchedEffect(key1 = Unit) {
        val dataSourceFactory = DefaultHttpDataSource.Factory()
        val uri = Uri.Builder().encodedPath(M3U8_URL).build()
        val mediaItem = MediaItem.Builder().setUri(uri).build()
        val internetVideoSource =
            HlsMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
        exoPlayer.setMediaSource(internetVideoSource)
        exoPlayer.prepare()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier =
            Modifier
                .fillMaxWidth()
                .aspectRatio(1.4f)
                .background(Color.Black),
            factory = {
                PlayerView(context).apply {
                    player = exoPlayer
                    exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
                    exoPlayer.playWhenReady = false
                    useController = true
                    setFullscreenButtonClickListener { isFullScreen ->
                        if (isFullScreen) {
                            activity.setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                            //TODO Arreglar que se sigue viendo la top bar
                            //Considerar e investigar uso de AndroidView()
                        }else{
                            activity.setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                        }
                    }
                }
            }
        )
    }


    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                exoPlayer.playWhenReady = false
            } else if (event == Lifecycle.Event.ON_PAUSE) {
                exoPlayer.playWhenReady = false
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    DisposableEffect(key1 = Unit) {
        onDispose {
            exoPlayer.stop()
            exoPlayer.release()
            //ExoPlayerManager.releaseExoPlayer()
        }
    }



}

@Preview
@Composable
fun VideoInformationView(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .border(width = 1.dp, color = Color.Black)
    ) {
        item {
            Text(
                text = "Pyramides de Egipto",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 10.dp). fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.videoDescription),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}



