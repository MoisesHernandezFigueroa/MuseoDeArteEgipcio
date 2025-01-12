package com.example.museodearteegipcio.views

import android.net.Uri
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.museodearteegipcio.R
import com.example.museodearteegipcio.navigation.ScreenRoutes
import com.example.museodearteegipcio.views.ExoPlayerManager.getExoPlayer
import kotlinx.coroutines.delay

data class Sound(
    val name: String,
    val sound: Int,
    val cover:Int,
    val duration: Long
)

@Composable
fun FuneraryBuildingsView() {

    lateinit var player: ExoPlayer
    val context = LocalContext.current

    fun getPlayList(): List<Sound> {
        return listOf(
            Sound(
                name = "Pirámide de Keops",
                sound = R.raw.audio_building_keops,
                cover = R.drawable.image_building_kheops,
                duration = getAudioDuration(context,R.raw.audio_building_keops)
                //description = "La Pirámide de Keops, también conocida como la Gran Pirámide de Giza, es una de las Siete Maravillas del Mundo Antiguo. Construida como la tumba del faraón Keops alrededor del 2560 a.C., se erige como un símbolo del poder y la habilidad arquitectónica de los antiguos egipcios. Con una altura original de 146 metros, fue la estructura más alta del mundo durante más de 3,800 años. Su diseño interior incluye pasajes complejos y cámaras funerarias para proteger al faraón en su viaje al más allá."
            ),
            Sound(
                name = "Pirámide de Saqqara",
                sound = R.raw.audio_building_saggara,
                cover = R.drawable.image_building_saggara,
                duration = getAudioDuration(context,R.raw.audio_building_saggara)
                //description = "La Pirámide Escalonada de Saqqara, diseñada por el arquitecto Imhotep, es la primera gran estructura de piedra de la historia. Construida para el faraón Zoser durante la Tercera Dinastía (c. 2670 a.C.), marcó un cambio revolucionario en la arquitectura funeraria egipcia. Sus seis niveles escalonados simbolizan una escalera hacia el cielo, ayudando al faraón a unirse a los dioses. Este monumento es un precursor esencial de las pirámides de Giza."
                //
            ),
            Sound(
                name = "Valle de los Reyes",
                sound = R.raw.audio_building_valle,
                cover = R.drawable.image_building_valle_de_reyes,
                duration = getAudioDuration(context,R.raw.audio_building_valle)
                //description = "El Valle de los Reyes es una necrópolis real situada en la orilla occidental del Nilo, cerca de Luxor. Durante el Imperio Nuevo (1539-1075 a.C.), sirvió como el lugar de descanso final para numerosos faraones, incluyendo a Tutankamón y Ramsés II. Las tumbas excavadas en la roca están decoradas con impresionantes murales que narran la vida de los faraones y su paso al más allá. Este sitio refleja la importancia de la vida después de la muerte en la cultura egipcia antigua."
                //
            ),
            Sound(
                name = "Templo Funerario de Hatshepsut",
                sound = R.raw.audio_building_hatshepshu,
                cover = R.drawable.image_building_hatshepsut,
                duration = getAudioDuration(context,R.raw.audio_building_hatshepshu)
                //description = "Ubicado en Deir el-Bahari, el Templo Funerario de Hatshepsut es una obra maestra de la arquitectura del Imperio Nuevo. Este templo único, dedicado a la reina Hatshepsut, combina elementos funerarios y religiosos. Su diseño en terrazas y su integración con el paisaje circundante demuestran un enfoque sofisticado hacia la arquitectura y el culto a los muertos. Además, celebra el poder y la divinidad de una de las pocas mujeres faraones de Egipto."
                //
            ),
            Sound(
                name = "Mastabas de Giza",
                sound = R.raw.audio_building_mascabas_giza,
                cover = R.drawable.image_buildings_mastabas_giza,
                duration = getAudioDuration(context,R.raw.audio_building_mascabas_giza)
                // description = "Las Mastabas de Giza son estructuras funerarias de la Época Predinástica que preceden a las pirámides. Estas tumbas de forma rectangular servían como lugares de enterramiento para nobles y altos funcionarios. Construidas con ladrillos de barro o piedra, las mastabas incluyen capillas para ofrendas y cámaras subterráneas donde se colocaban los cuerpos y sus pertenencias. Su diseño básico influyó en la evolución arquitectónica hacia las pirámides escalonadas."
                //
            ),
            Sound(
                name = "Pirámide Roja",
                sound = R.raw.audio_building_piramide_roja,
                cover = R.drawable.image_building_piramide_roja,
                duration = getAudioDuration(context,R.raw.audio_building_piramide_roja)
                //description = "La Pirámide Roja, situada en Dahshur, es la primera pirámide verdadera de Egipto, atribuida al faraón Snefru de la Cuarta Dinastía (c. 2600 a.C.). Su color rojizo proviene de la piedra caliza utilizada en su construcción. Con una altura de 105 metros, representa un avance técnico significativo en comparación con las estructuras anteriores. Aunque su interior es más simple que otras pirámides, es un ejemplo clave de la transición hacia las pirámides clásicas."
                //
            )
        )
    }

    player = getExoPlayer(context)
    val playList = getPlayList()

    val pagerState = rememberPagerState(pageCount = { playList.count() })
    val playingSongIndex = remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(pagerState.currentPage) {//Cambiar la pista que esta corriendo con movimiento de pager
        playingSongIndex.intValue = pagerState.currentPage
        player.seekTo(pagerState.currentPage, 0)
    }

    LaunchedEffect(player.currentMediaItemIndex) {
        playingSongIndex.intValue = player.currentMediaItemIndex
        pagerState.animateScrollToPage(
            playingSongIndex.intValue,
            animationSpec = tween(500)
        )
    }

    LaunchedEffect(Unit) {
        playList.forEach {
            val path = "android.resource://" + context.packageName + "/" + it.sound
            val mediaItem = MediaItem.fromUri(Uri.parse(path))
            player.addMediaItem(mediaItem)
        }

    }

    player.prepare()

    DisposableEffect(Unit) {
        // Listener para controlar la transición entre MediaItems
        val listener = object : Player.Listener {
            override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                if (reason == Player.MEDIA_ITEM_TRANSITION_REASON_AUTO) {
                    player.pause() // Detener el reproductor automáticamente
                }
            }
        }

        player.addListener(listener)

        onDispose {
            //player.removeListener(listener)
            //player.release() // Liberar recursos cuando el Composable se destruye
        }
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                ExoPlayerManager.releaseExoPlayer()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    val isPlaying = remember {
        mutableStateOf(false)
    }
    val currentPosition = remember {
        mutableLongStateOf(0)
    }
    val sliderPosition = remember {
        mutableLongStateOf(0)
    }
    val totalDuration = remember {
        mutableLongStateOf(0)
    }

    LaunchedEffect(key1 = player.currentPosition, key2 = player.isPlaying) {
            while (true) { //Esto me funciono mejor que el presentado en TLG (Ver original)
                delay(500)
                currentPosition.longValue = player.currentPosition
            }
    }

    LaunchedEffect(currentPosition.longValue) {
        sliderPosition.longValue = currentPosition.longValue
    }

    LaunchedEffect(player.duration) {//Not Used
        if (player.duration > 0) {
            totalDuration.longValue = player.duration
        }
    }

    LaunchedEffect(player.isPlaying) {//Adicional a TLG
        if (!player.isPlaying)
            isPlaying.value = player.isPlaying
    }


    ///////////////////////PARTE GRAFICA////////////////////////////////////
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        val configuration = LocalConfiguration.current
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalPager(
                modifier = Modifier.fillMaxWidth(),
                state = pagerState,
                pageSize = PageSize.Fill,
                contentPadding = PaddingValues(horizontal = 20.dp)
            ) { page ->
                val painter = painterResource(id = playList[page].cover)
                Box (modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                    contentAlignment = Alignment.Center){
                    Image(painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
            ) {
                TrackSliderTLG(
                    value = sliderPosition.longValue.toFloat(),
                    onValueChange = {
                        sliderPosition.longValue = it.toLong()
                    },
                    onValueChangeFinished = {
                        currentPosition.longValue = sliderPosition.longValue
                        //player.seekTo(sliderPosition.longValue)
                    },
                    songDuration = playList[playingSongIndex.intValue].duration.toFloat()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(text = (currentPosition.longValue).convertToText(),
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        color = Color.Black,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                    val remainTime = playList[playingSongIndex.intValue].duration - currentPosition.longValue
                    Text(
                        text = if (remainTime >= 0) remainTime.convertToText() else "",
                    modifier = Modifier
                        .padding(8.dp),
                    color = Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ControlButton(
                    icon = androidx.media3.ui.R.drawable.exo_icon_previous,
                    size = 40.dp, onClick = {//previous
                        player.seekToPreviousMediaItem()
                    })
                Spacer(modifier = Modifier.width(20.dp))
                ControlButton(
                    icon = if (isPlaying.value) androidx.media3.ui.R.drawable.exo_icon_pause else androidx.media3.ui.R.drawable.exo_icon_play,//pause y play
                    size = 100.dp,
                    onClick = {
                        if (isPlaying.value) {
                            player.pause()
                        } else {
                            player.play()
                        }
                        isPlaying.value = !isPlaying.value
                    })
                Spacer(modifier = Modifier.width(20.dp))
                ControlButton(
                    icon = androidx.media3.ui.R.drawable.exo_icon_next,
                    size = 40.dp,
                    onClick = {//next
                        player.seekToNextMediaItem()
                    })
            }
        }
    }

}

@Composable
fun ControlButton(icon: Int, size: Dp, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .clickable {
                onClick()
            }, contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(size / 1.5f),
            painter = painterResource(id = icon),
            tint = Color.Black,
            contentDescription = null
        )
    }
}

@Composable
fun TrackSliderTLG(
    value: Float,
    onValueChange: (newValue: Float) -> Unit,
    onValueChangeFinished: () -> Unit,
    songDuration: Float
) {
    Slider(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        onValueChangeFinished = {
            onValueChangeFinished()
        },
        valueRange = 0f..songDuration,
        colors = SliderDefaults.colors(
            thumbColor = Color.Black,
            activeTrackColor = Color.DarkGray,
            inactiveTrackColor = Color.Gray,
        )
    )
}

private fun Long.convertToText(): String {
    val sec = this / 1000
    val minutes = sec / 60
    val seconds = sec % 60
    val minutesString = if (minutes < 10) {"0$minutes"
    } else {
        minutes.toString()
    }
    val secondsString = if (seconds < 10) {
        "0$seconds"
    } else {
        seconds.toString()
    }
    return "$minutesString:$secondsString"
}
