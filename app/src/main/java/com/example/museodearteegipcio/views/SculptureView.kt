package com.example.museodearteegipcio.views

import android.net.Uri
import androidx.annotation.RawRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil3.compose.AsyncImage
import com.example.museodearteegipcio.R
import com.example.museodearteegipcio.navigation.ScreenRoutes
import kotlin.math.absoluteValue
import kotlin.math.floor
import kotlin.math.round

data class ScultureInfo(
    val title: String,
    val description: String,
    val pictureUrl: String,
    @RawRes val resId: Int
)

//Intentar hacer drag and drop
@Composable
fun SculptureView() {

    val cardScultureInfo = listOf(
        ScultureInfo(
            title = "Gran Esfinge de Giza",
            description = "Una imponente estatua con cuerpo de león y cabeza humana, símbolo de sabiduría y poder, ubicada en la meseta de Giza.",
            pictureUrl = "https://planegypttours.com/files/xlarge/1401720309-La-Gran-Esfinge-de-Guiza.jpg",
            resId = R.raw.video_sculpture_esfinge
        ),
        ScultureInfo(
            title = "Busto de Nefertiti",
            description = "Un retrato que simboliza la belleza y el poder de la reina Nefertiti, esculpido en piedra caliza.",
            pictureUrl = "https://images.ecestaticos.com/XbE4pYD7nvQgVI-vFqFCRtUaFl4=/0x0:1599x674/1600x675/filters:fill(white):format(jpg):quality(99)/f.elconfidencial.com/original/80d/d8f/d9f/80dd8fd9f0d84ab83b15e23ce55ce08b.jpg",
            resId = R.raw.video_sculpture_nefertiti
        ),
        ScultureInfo(
            title = "Colosos de Memnón",
            description = "Dos gigantescas estatuas de piedra que representan al faraón Amenhotep III, situadas en Luxor.",
            pictureUrl = "https://www.egipto.com/wp-content/uploads/2022/03/colosos-memnon-egipto.jpg",
            resId = R.raw.video_sculpture_colosos_mennon
        ),
        ScultureInfo(
            title = "Estatua de Ramsés II",
            description = "Unas de las estatuas más emblemáticas del faraón Ramsés II, situada en el Gran Templo de Abu Simbel.",
            pictureUrl = "https://historia.nationalgeographic.com.es/medio/2022/06/10/detalle-de-la-cabeza-de-la-estatua-colosal-de-ramses-ii-en-menfis-descubierta-por-caviglia-en-1820_78da95e6_1280x723.jpg",
            resId = R.raw.video_sculpture_ramses
        ),
        ScultureInfo(
            title = "Estatua de Anubis",
            description = "Una estatua del dios de los muertos, Anubis, que simboliza la protección y guía en el más allá.",
            pictureUrl = "https://theancienthome.es/cdn/shop/files/006-anubis-statue-SCAN3912023_1024x1024_dcbcff75-8d16-44ff-a150-3b74deac7cbb.jpg?v=1720693290&width=1080",
            resId = R.raw.video_sculpture_anubis
        )
    )

    val pagerState = rememberPagerState(pageCount = { cardScultureInfo.size * 2})

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) { page ->
            val auxValue: Int = floor((page/2).toFloat()).toInt()
            when (page % 2) {
                0 -> SculturePageDescription(cardScultureInfo[auxValue])
                1 -> SculpturePageVideo(cardScultureInfo[auxValue])
            }
        }

        Row( //Indicador de posicion del pager
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }



    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SculturePageDescription(sculpture: ScultureInfo){

    //Falta agregar boton para animar que salga la descripcion


    ElevatedCard(
        modifier = Modifier
            .fillMaxSize(),
        onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ) {
        AsyncImage(model = sculpture.pictureUrl,
            contentDescription = sculpture.description ,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop)
        Text( //Title
            text = sculpture.title,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text( //Description
            text = sculpture.description,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SculpturePageVideo(sculpture: ScultureInfo){
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    // Configura ExoPlayer para el video actual
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val videoUri = Uri.parse("android.resource://${context.packageName}/${sculpture.resId}")
            val mediaItem = MediaItem.fromUri(videoUri)
            setMediaItem(mediaItem)
            prepare()
        }
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

    ElevatedCard(
        modifier = Modifier
            .fillMaxSize(),
        onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
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
                    .height(300.dp)
            )
        }
    }
}
