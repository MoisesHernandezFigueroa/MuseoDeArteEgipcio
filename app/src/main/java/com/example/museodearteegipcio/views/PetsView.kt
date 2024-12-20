package com.example.museodearteegipcio.views

import android.annotation.SuppressLint
import android.content.Context
import android.icu.number.IntegerWidth
import android.icu.text.ListFormatter.Width
import android.media.MediaMetadataRetriever
import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.museodearteegipcio.R
import com.example.museodearteegipcio.views.ExoPlayerManager.getExoPlayer
import kotlinx.coroutines.delay

data class PetCardInfo(
    val name: String,
    val imageURL: String,
    val audio: Int,
    val duration: Long = 0L
)

fun getAudioDuration(context: Context, resId: Int): Long {
    val retriever = MediaMetadataRetriever()
    val uri = "android.resource://${context.packageName}/$resId"
    retriever.setDataSource(context, Uri.parse(uri))
    val duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)?.toLong() ?: 0L
    retriever.release()
    return duration
}

@SuppressLint("DefaultLocale")
fun formatTime(milliseconds: Long): String {
    val totalSeconds = milliseconds / 1000
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return String.format("%02d:%02d", minutes, seconds)
}

@OptIn(UnstableApi::class)
@Composable
fun PetsView() {

    lateinit var player: ExoPlayer
    val context = LocalContext.current

    fun getPetCards(): List<PetCardInfo> {
        val imageList = listOf(
            "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-06Sphynx.jpg?itok=oUrAvazr",
            "https://media.admagazine.com/photos/64f94c88cfbb183dcb271dac/16:9/w_2560%2Cc_limit/xoloitzcuintle.jpg",
            "https://s1.elespanol.com/2023/11/28/enclave-ods/historias/813178978_237981262_1706x1280.jpg",
            "https://media.audubon.org/nas_birdapi_hero/h_prairie-falcon_004_shutterstock_1220666524_adult_jaypierstorff.jpg?height=944&auto=webp&quality=90&fit=bounds&disable=upscale",
            "https://statics.forbesargentina.com/2023/03/6411e3b0a6dc2.jpg",
        )
        return listOf(
            PetCardInfo("Gato egipcio", imageList[0], R.raw.cat, getAudioDuration(context, R.raw.cat)),
            PetCardInfo("Perro egipcio", imageList[1], R.raw.dog,getAudioDuration(context, R.raw.dog)),
            PetCardInfo("Ibis", imageList[2], R.raw.ibis,getAudioDuration(context, R.raw.ibis)),
            PetCardInfo("Halcon",imageList[3], R.raw.falcon,getAudioDuration(context, R.raw.falcon)),
            PetCardInfo("Camello", imageList[4], R.raw.camel,getAudioDuration(context, R.raw.camel))
        )
    }

    player = getExoPlayer(context)
    val cardsPlayList = getPetCards()


    LaunchedEffect(Unit) {//se ejecuta una vez
        cardsPlayList.forEach{card->
            val path = "android.resource://${context.packageName}/${card.audio}"
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


    //Composable que llama a todas las tarjetas de los animales
    AllPetsView(player,cardsPlayList)
}

@Composable
fun AllPetsView(
    player: ExoPlayer,
    petsList : List<PetCardInfo>,
){

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            InstructionCard()
        }

        items(5){index->
            SinglePetCard(player, index, petsList)
        }
    }

}

@Composable
fun InstructionCard(){
    Card( // Tarjeta principal
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = "Instrucciones",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.petsInstructions),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@OptIn(UnstableApi::class)
@Composable
fun SinglePetCard(
    player: ExoPlayer,
    index: Int,
    petsList: List<PetCardInfo>,
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
            val (topSpace, card, image, title) = createRefs() // Definimos las referencias de los elementos

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
                    .height(230.dp)
                    .constrainAs(card) {
                        top.linkTo(topSpace.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))//Espacio para el reproductor de audio

                Row(modifier = Modifier.fillMaxWidth(),
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
                        songDuration = petsList[index].duration.toFloat(),
                        width = 250
                    )

                    Text(text = "${formatTime(sliderPosition.value)}/${formatTime(petsList[index].duration)}",
                        fontSize = 10.sp)
                }

            }

            // Imagen que sobresale en la parte superior del Card
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(petsList[index].imageURL)
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
            // Título debajo de la imagen
            Text(
                text = petsList[index].name, //Nombre del animal
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .constrainAs(title) {
                        top.linkTo(image.bottom)
                        start.linkTo(card.start)
                        end.linkTo(card.end)
                    }
            )
        }
    }
}


@Composable
fun TrackSlider( //Track slider tomado de TLG
    value: Float,
    onValueChange: (newValue: Float) -> Unit,
    onValueChangeFinished: () -> Unit,
    songDuration: Float,
    width: Int
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
        ),
        modifier = Modifier.width(width.dp)
    )
}
