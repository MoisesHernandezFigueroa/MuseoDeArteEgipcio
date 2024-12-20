package com.example.museodearteegipcio.views

import android.net.Uri
import androidx.annotation.OptIn
import androidx.annotation.RawRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.ui.PlayerView
import com.example.museodearteegipcio.R

@Composable
fun WorkingView() {
    // Lista de videos con sus títulos
    val videoList = listOf(
        VideoInfo(title = "Comercio en Egipto", resId = R.raw.video_trading_work),
        VideoInfo(title = "Trabajos de construccion", resId = R.raw.video_building_work),
        VideoInfo(title = "Trabajo de agricultura", resId = R.raw.video_agriculture_work)
//        VideoInfo(title = "Video 1", url = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"),
//        VideoInfo(title = "Video 1", url = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"),
//        VideoInfo(title = "Video 1", url = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8")
    )

    // Pantalla principal con los videos
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(videoList) { video ->
            SingleVideoView(video)
        }
    }
}

// Data class para almacenar información de cada video
data class VideoInfo(
    val title: String,
    @RawRes val resId: Int
    //val url: String
)

@OptIn(UnstableApi::class)
@Composable
fun SingleVideoView(videoInfo: VideoInfo) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    // Configura ExoPlayer para el video actual

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val videoUri = Uri.parse("android.resource://${context.packageName}/${videoInfo.resId}")
            val mediaItem = MediaItem.fromUri(videoUri)
            setMediaItem(mediaItem)
            prepare()
        }
    }


//    val exoPlayer = remember { ExoPlayerManager.getExoPlayer(context) }
//
//    LaunchedEffect(key1 = Unit) {
//        val dataSourceFactory = DefaultHttpDataSource.Factory()
//        val uri = Uri.Builder().encodedPath(M3U8_URL).build()
//        val mediaItem = MediaItem.Builder().setUri(uri).build()
//        val internetVideoSource =
//            HlsMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
//        exoPlayer.setMediaSource(internetVideoSource)
//        exoPlayer.prepare()
//    }

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

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.stop()
            exoPlayer.release()
            //ExoPlayerManager.releaseExoPlayer()
        }
    }

    // Card que contiene el reproductor y el título
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Reproductor de video
            AndroidView(
                factory = {
                    PlayerView(it).apply {
                        player = exoPlayer
                        useController = true // Mostrar controles de reproducción
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Deja que el reproductor ocupe la mayor parte del espacio
            )

            // Título del video
            Text(
                text = videoInfo.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}