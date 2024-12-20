package com.example.museodearteegipcio.views

import android.net.Uri
import androidx.annotation.OptIn
import androidx.annotation.RawRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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


// Data class para almacenar información del templo
data class TempleInfo(
    val templeName: String,
    val templeImage: Int,
    val description: String,
    val godName: String,
    val godImage: Int,
    @RawRes val resId: Int
    //val url: String
)

// Lista de templos
val templesList = listOf(
    TempleInfo(
        templeName = "Templo de Luxor",
        templeImage = R.drawable.image_temple_luxor,
        description = "El Templo de Luxor es un antiguo complejo egipcio dedicado al dios Amón.",
        godName = "Amón",
        godImage = R.drawable.image_god_amon,
        resId = R.raw.video_temple_luxor
        //url = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    ),
    TempleInfo(
        templeName = "Templo de Karnak",
        templeImage = R.drawable.image_temple_karnak,
        description = "El Templo de Karnak es un enorme complejo religioso construido en honor a Amón-Ra.",
        godName = "Amón-Ra",
        godImage = R.drawable.image_amonra_god,
        resId = R.raw.video_temple_karnak
        //url = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    ),
    TempleInfo(
        templeName = "Templo de Abu Simbel",
        templeImage = R.drawable.image_temple_abu_simbel,
        description = "Un impresionante templo tallado en roca dedicado a Ramsés II y Nefertari.",
        godName = "Ramsés II",
        godImage = R.drawable.image_ramsesii_god,
        resId = R.raw.video_temple_abusimbel
        //url = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    ),
    TempleInfo(
        templeName = "Templo de Edfu",
        templeImage = R.drawable.image_temple_edfu,
        description = "Dedicado al dios Horus, es uno de los templos mejor conservados de Egipto.",
        godName = "Horus",
        godImage = R.drawable.image_horus_god,
        resId = R.raw.video_temple_edfu
        //url = "https://example.com/edfu-video.m3u8"
    ),
    TempleInfo(
        templeName = "Templo de Philae",
        templeImage = R.drawable.image_temple_philae,
        description = "Construido en honor a la diosa Isis, este templo se encuentra en una isla cerca de Asuán.",
        godName = "Isis",
        godImage = R.drawable.image_isis_god,
        resId = R.raw.video_temple_philae
        //url = "https://example.com/philae-video.m3u8"
    )
)


@Preview
@Composable
fun TemplesView() {

    val pagerState = rememberPagerState(pageCount = { templesList.size })

    Row (modifier = Modifier.fillMaxSize()){//De lado izquierdo tendra el indicador de pagina y del lado derecho el pager
        Column( //Indicador de pagina
            Modifier
                .fillMaxHeight()
                .width(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        //.clip(CircleShape)
                        .height(100.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(color)
                        .size(16.dp)
                )
            }
        }

        //Pager pricipal
        VerticalPager(state = pagerState,
            modifier = Modifier.fillMaxSize())
        {page->
            SingleTempleView(templeInfo = templesList[page],)
        }
    }



}

@OptIn(UnstableApi::class)
@Composable
fun SingleTempleView(templeInfo: TempleInfo) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    // Configura ExoPlayer para el video actual
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val videoUri = Uri.parse("android.resource://${context.packageName}/${templeInfo.resId}")
            val mediaItem = MediaItem.fromUri(videoUri)
            setMediaItem(mediaItem)
            prepare()
        }
    }

//    val exoPlayer = remember {
//        ExoPlayer.Builder(context).build().apply {
//            val videoUri = Uri.parse("android.resource://${context.packageName}/${templeInfo.resId}")
//            val mediaItem = MediaItem.fromUri(videoUri)
//            setMediaItem(mediaItem)
//            prepare()
//        }
//    }

    //Exoplayer cuando se hace por red
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

    DisposableEffect(key1 = Unit) {
        onDispose {
            exoPlayer.stop()
            exoPlayer.release()
            //ExoPlayerManager.releaseExoPlayer()
        }
    }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 2.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            // Referencias para los elementos
            val (templeImage, templeName, description,video, godName, godImage) = createRefs()

            // Imagen del templo
            Image(
                painter = painterResource(id = templeInfo.templeImage),
                contentDescription = "Imagen del templo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .constrainAs(templeImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )

            // Nombre del templo
            Text(
                text = templeInfo.templeName,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .constrainAs(templeName) {
                        top.linkTo(templeImage.top)
                        bottom.linkTo(templeImage.bottom)
                        start.linkTo(templeImage.end)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                overflow = TextOverflow.Ellipsis
            )

            // Descripción del templo
            Text(
                text = templeInfo.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(description) {
                        top.linkTo(templeImage.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            )

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
                    .constrainAs(video) {// Deja que el reproductor ocupe la mayor parte del espacio
                        top.linkTo(description.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        bottom.linkTo(godImage.top, margin = 10.dp)
                        height = Dimension.fillToConstraints
                    }
            )

            // Nombre del dios
            Text(
                text = templeInfo.godName,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.constrainAs(godName) {
                    top.linkTo(godImage.top, margin = 90.dp)
                    end.linkTo(godImage.start, margin = 16.dp)
                }
            )

            // Imagen del dios (circular)
            Image(
                painter = painterResource(id = templeInfo.godImage),
                contentDescription = "Imagen del dios",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .constrainAs(godImage) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}
