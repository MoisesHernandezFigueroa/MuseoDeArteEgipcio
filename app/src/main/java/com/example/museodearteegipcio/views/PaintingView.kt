package com.example.museodearteegipcio.views

import android.net.Uri
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.museodearteegipcio.R
import kotlinx.coroutines.delay
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.draw.clip

import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.museodearteegipcio.navigation.ScreenRoutes
import com.example.museodearteegipcio.views.ExoPlayerManager.getExoPlayer
import kotlinx.coroutines.delay

data class HistoricMomentInfo(
    val imageURL: String,
    val audio: Int,
    val duration: Long = 0L
)


@Preview
@OptIn(ExperimentalWearMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PaintingView() {
    //lateinit var player: ExoPlayer
    val context = LocalContext.current

    val baseAnchor = 60.dp //El anchor de cada incremento
    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { baseAnchor.toPx() }
    val anchors = mapOf(
        0f to 0,
        sizePx to 1,
        sizePx * 2 to 2,
        sizePx * 3 to 3,
        sizePx * 4 to 4,
        sizePx * 5 to 5,
        sizePx * 6 to 6,
        sizePx * 7 to 7,
        sizePx * 8 to 8,
        sizePx * 9 to 9,
        //sizePx * 10 to 10
    )

    fun getPlayList(): List<HistoricMomentInfo> {
        return listOf(
            HistoricMomentInfo(
                imageURL = "https://weepingredorger.wordpress.com/wp-content/uploads/2013/04/tvz8iqndd8iiqnneox4caef88ee6b35_menes-el-primer-faraon.jpg",
                audio = R.raw.audio_historic1,
                duration = getAudioDuration(context, R.raw.audio_historic1)
            ),
            HistoricMomentInfo(
                imageURL = "https://sobrehistoria.com/wp-content/uploads/2010/07/el-misterio-de-c%C3%B3mo-se-construyeron-las-pir%C3%A1mides-de-egipto-600x409.jpg",
                audio = R.raw.audio_historic2,
                duration = getAudioDuration(context, R.raw.audio_historic2)
            ),
            HistoricMomentInfo(
                imageURL = "https://www.lavanguardia.com/files/content_image_mobile_filter/uploads/2019/07/08/5f15f3b3ae367.jpeg",
                audio = R.raw.audio_historic3,
                duration = getAudioDuration(context, R.raw.audio_historic3)
            ),
            HistoricMomentInfo(
                imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeFELiR60r7ntr7MoalPsMRwAY9xzgItnquA&s",
                audio = R.raw.audio_historic4,
                duration = getAudioDuration(context, R.raw.audio_historic4)
            ),
            HistoricMomentInfo(
                imageURL = "https://s0.smartresize.com/wallpaper/582/926/HD-wallpaper-golden-age-temple-cool-fantasy-egypt.jpg",
                audio = R.raw.audio_historic5,
                duration = getAudioDuration(context, R.raw.audio_historic5)
            ),
            HistoricMomentInfo(
                imageURL = "https://e00-elmundo.uecdn.es/suplementos/imagenes/2006/08/30/1156935836_0.jpg",
                audio = R.raw.audio_historic6,
                duration = getAudioDuration(context, R.raw.audio_historic6)
            ),
            HistoricMomentInfo(
                imageURL = "https://static.nationalgeographic.es/files/styles/image_3200/public/01-king-tut.jpg?w=1900&h=2346",
                audio = R.raw.audio_historic7,
                duration = getAudioDuration(context, R.raw.audio_historic7)
            ),
            HistoricMomentInfo(
                imageURL = "https://imgcdn.stablediffusionweb.com/2024/9/17/03ad40bd-a9ae-4a5d-902f-67e2667c98b8.jpg",
                audio = R.raw.audio_historic8,
                duration = getAudioDuration(context, R.raw.audio_historic8)
            ),
            HistoricMomentInfo(
                imageURL = "https://cdn.labrujulaverde.com/wp-content/uploads/2017/07/Le_roi_Cambyse_au_siege_de_Peluse_par_Paul-Marie_Lenoir-1.jpg",
                audio = R.raw.audio_historic9,
                duration = getAudioDuration(context, R.raw.audio_historic9)
            ),
            HistoricMomentInfo(
                imageURL = "https://antiguagrecia.net/wp-content/uploads/alexander-el-grande-ante-las-piramides-egipcias-88_1.webp",
                audio = R.raw.audio_historic10,
                duration = getAudioDuration(context, R.raw.audio_historic10)
            ),
            HistoricMomentInfo(
                imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSi4mjQzyipCjXxq_F_ER5WUZHy4T5Sspz6UA&s",
                audio = R.raw.audio_historic11,
                duration = getAudioDuration(context, R.raw.audio_historic11)
            ),
        )

    }

    val player = getExoPlayer(context)
    val historicPlayList = getPlayList()

    LaunchedEffect(Unit) {//se ejecuta una vez
        historicPlayList.forEach{
            val path = "android.resource://${context.packageName}/${it.audio}"
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
                    player.pause() // Detén el reproductor automáticamente
                }
            }
        }

        player.addListener(listener)

        onDispose {
            player.removeListener(listener)
            player.release() // Liberar recursos cuando el Composable se destruye
        }
    }


    ///////////////////////////////////PARTE GRAFICA///////////////////////////////////////////////////
    Column() {
        Text( //Titulo de la pantalla
            text = "Mueve la linea del tiempo y descubre lo que pasa",
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )

        //Hacer 2 columnas verticales, una que sera la linea del tiempo y otra que sera la descripcion
        Row(modifier = Modifier.fillMaxSize()) {

            Box( //Columna donde esta la linea del tiempo
                modifier = Modifier
                    .weight(1f) //Box con swipeable con linea del tiempo
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(), //Al principio estara anio inicial y al final el anio final
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "3100 a.C .",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    //Swipeable device
                    Box(                //Carril central donde se hara el drag
                        modifier = Modifier
                            .height((baseAnchor * 10))
                            .padding(top = 2.dp, bottom = 2.dp, start = 16.dp, end = 16.dp)
                            .swipeable(
                                swipeableState,
                                anchors = anchors,
                                thresholds = { _, _ -> FractionalThreshold(0.2f) },
                                orientation = Orientation.Vertical,
                            )
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Divider( //Divider vertical para simular la linea del tiempo
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(5.dp),
                            color = Color.Black
                        )

                        Box(            //Draggable circular color cyan
                            modifier = Modifier
                                .offset {
                                    IntOffset(0, swipeableState.offset.value.toInt())
                                }
                                .size(baseAnchor)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.secondary)) {
                        }
                    }

                    Text(
                        text = "332 a.C .",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                } //End Column
            }

            Box( //Columna donde estara la parte de audios
                modifier = Modifier
                    .weight(2.5f)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AnimatedCard(index = swipeableState.currentValue)
                    Spacer(modifier = Modifier.height(20.dp))
                    SingleHistoricMoment(
                        player = player,
                        index = swipeableState.currentValue,
                        historicPlayList = historicPlayList
                    )
                }
            }
        } //End row
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimatedCard(index: Int) {

    val context = LocalContext.current
    var cardState by remember { mutableStateOf(0) }
    var currentRotation by remember { mutableFloatStateOf(0f) }
    val rotation = remember { androidx.compose.animation.core.Animatable(currentRotation) }
    val years = context.resources.getStringArray(R.array.year)
    val historicMoments = context.resources.getStringArray(R.array.historicMoment)

    LaunchedEffect(cardState != index) {
        cardState = index
        rotation.animateTo(
            targetValue = currentRotation + 360f,
            animationSpec = tween(3000)
        ) {
            currentRotation = value
        }
    }

    AnimatedContent(
        targetState = cardState,
        transitionSpec = {
            fadeIn(
                animationSpec = tween(1000)
            ) togetherWith fadeOut(animationSpec = tween(3000))
        },
        modifier = Modifier
    ) { targetState ->

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .rotate(currentRotation),
            elevation = androidx.compose.material3.CardDefaults.cardElevation(10.dp),
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = years[targetState],
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Text(
                text = historicMoments[targetState],
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }


    }

}

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun SingleHistoricMoment(
    player: ExoPlayer,
    index: Int,
    historicPlayList: List<HistoricMomentInfo>,
){

    val isPlaying = remember { mutableStateOf(false) }
    val currentPosition = remember { mutableLongStateOf(0) }
    val sliderPosition = remember { mutableLongStateOf(0) }

    LaunchedEffect(player) {
        while (true) {
            delay(500)
            currentPosition.longValue = player.currentPosition
        }
    }

    LaunchedEffect(currentPosition.longValue) {
        if(isPlaying.value) sliderPosition.longValue = currentPosition.longValue
        else sliderPosition.longValue = 0L
    }

    LaunchedEffect(player.isPlaying) {
        if (!player.isPlaying)
            isPlaying.value = player.isPlaying
    }



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (topSpace, card, image) = createRefs() // Definimos las referencias de los elementos

            Spacer(modifier = Modifier
                .height(100.dp)
                .constrainAs(topSpace) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

            Card( // Tarjeta principal
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .constrainAs(card) {
                        top.linkTo(topSpace.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Spacer(modifier = Modifier.weight(0.7f))
                Row(modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically)
                {
                    IconButton(onClick = {
                        player.seekTo(index,0)
                        //Toast.makeText(context, "${totalDuration.value}", Toast.LENGTH_SHORT).show()
                        if (isPlaying.value) player.pause()
                        else player.play()

                        isPlaying.value = !isPlaying.value
                    }) {
                        if (isPlaying.value) {
                            Icon(painter = painterResource(id = R.drawable.stop),
                                contentDescription = "Stop",
                                modifier = Modifier.size(60.dp))
                        }else Icon(painter = painterResource(id = R.drawable.play),
                            contentDescription = "play",
                            modifier = Modifier.size(60.dp))
                    }


                    TrackSlider( //Track slider tomado de TLG
                        value = sliderPosition.value.toFloat(),
                        onValueChange = {
                            sliderPosition.value = it.toLong()
                        },
                        onValueChangeFinished = {
                            currentPosition.value = sliderPosition.value
                            // player.seekTo(sliderPosition.value)
                        },
                        songDuration = historicPlayList[index].duration.toFloat(),
                        width = 120
                    )

                    Text(text = "${formatTime(sliderPosition.value)}/${formatTime(historicPlayList[index].duration)}",
                        fontSize = 10.sp)

                }

            }

            // Imagen que sobresale en la parte superior del Card
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(historicPlayList[index].imageURL)
                    .build(),
                contentDescription = "Imagen descriptiva",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    .constrainAs(image) {
                        top.linkTo(card.top, margin = (-100).dp)
                        start.linkTo(card.start)
                        end.linkTo(card.end)
                    },
                contentScale = ContentScale.Crop
            )
        }
    }
}