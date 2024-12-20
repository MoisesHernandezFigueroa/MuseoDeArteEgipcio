package com.example.museodearteegipcio.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import android.content.ClipData
import android.content.ClipDescription
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.draganddrop.mimeTypes
import androidx.compose.ui.draganddrop.toAndroidDragEvent
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.museodearteegipcio.R

@Preview
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BuildingTechniquesView() {

    val imageEgiptian1 = remember { mutableStateOf("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwFIriA-UtcYKA0UcqJhybcYGKKHKOOQ1wZA&s") }
    val imageEgiptian2 = remember { mutableStateOf("https://wiki-ead.b-cdn.net/images/thumb/3/34/Herramientas_ant._egipto.png/400px-Herramientas_ant._egipto.png") }
    val imageEgiptian3 = remember { mutableStateOf("https://ccesantlluis.es/wp-content/uploads/2024/03/conoce-los-antiguos-taladros-utilizados-por-los-egipcios-1024x485.jpg") }
    //martillo
    val imageModern1 = remember { mutableStateOf("https://m.media-amazon.com/images/I/61P7zaUi6gL.jpg") }
    //pinzas
    val imageModern2 = remember { mutableStateOf("https://www.truper.com/media/product/5d5/juego-de-dos-pinzas-de-presion-curvas-mango-de-vinil-truper-4ca.jpg") }
    //taladro
    val imageModern3 = remember { mutableStateOf("https://www.fixferreterias.com/media/product/438/taladro-3-8-450w-truper-industrialtal-3-8n2-358.jpg") }

    var currentDragedItem by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BuildingInstructionCard()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.weight(0.15f),
            ,horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DraggableToolImage(modifier = Modifier
                .size(150.dp)
                .padding(12.dp)
                    ,url = imageEgiptian1.value
                ,isEgyptian = true){
                currentDragedItem = 1
            }
            DraggableToolImage(modifier = Modifier
                .size(150.dp)
                .padding(12.dp)
                ,url = imageEgiptian2.value
                ,isEgyptian = true){
                currentDragedItem = 2
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.weight(0.25f),
            ,horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DraggableToolImage(modifier = Modifier
                .size(150.dp)
                .padding(12.dp)
                ,url = imageModern1.value
                ,isEgyptian = false){
                currentDragedItem = 3
            }
            DraggableToolImage(modifier = Modifier
                .size(150.dp)
                .padding(12.dp)
                ,url = imageEgiptian3.value, isEgyptian = true){
                currentDragedItem =4
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.weight(0.25f),
            ,horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DraggableToolImage(modifier = Modifier
                .size(150.dp)
                .padding(12.dp)
                ,url = imageModern2.value , isEgyptian = false){
                currentDragedItem = 5
            }
            DraggableToolImage(modifier = Modifier
                .size(150.dp)
                .padding(12.dp)
                ,url = imageModern3.value, isEgyptian = false){
                currentDragedItem = 6
            }
        }

        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically){
            DropTargetToolImage(
                modifier = Modifier.fillMaxWidth()
                    .padding(12.dp),
                isEgyptian = true,
                textInBox = "Cultura Egipto"
            ) {
                when (currentDragedItem) {
                    1 -> imageEgiptian1.value = it
                    2 -> imageEgiptian2.value = it
                    3 -> imageModern1.value = it
                    4 -> imageEgiptian3.value = it
                    5 -> imageModern2.value = it
                    6 -> imageModern3.value = it
                }
            }

            DropTargetToolImage(
                modifier = Modifier.fillMaxWidth(),
                isEgyptian = false,
                textInBox = "Cultura Moderna"
            ) { when (currentDragedItem) {
                1 -> imageEgiptian1.value = it
                2 -> imageEgiptian2.value = it
                3 -> imageModern1.value = it
                4 -> imageEgiptian3.value = it
                5 -> imageModern2.value = it
                6 -> imageModern3.value = it
            } }
        }

        }

    }


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableToolImage(
    modifier: Modifier,
    url: String,
    isEgyptian: Boolean,
    onDragStarted: () -> Unit,
) {
    Box(modifier = modifier) {
        AsyncImage(model = url,
            contentDescription = "Dragged Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .background(Color.White) //
                .dragAndDropSource {
                    detectTapGestures(
                        onLongPress = {
                            onDragStarted()
                            startTransfer(
                                DragAndDropTransferData(
                                    ClipData.newPlainText("image uri", isEgyptian.toString())
                                )
                            )
                        }
                    )
                }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DropTargetToolImage(
    modifier: Modifier = Modifier,
    isEgyptian: Boolean,
    textInBox: String,
    onGiveResult: (String) -> Unit
) {

    val urlCheck =
        "https://st.depositphotos.com/1775533/1288/i/450/depositphotos_12880120-stock-photo-green-check-mark.jpg"
    val urlCross =
        "https://static.vecteezy.com/system/resources/previews/023/556/644/non_2x/cross-check-symbol-on-transparent-background-free-png.png"

    val updatedImage = remember { mutableStateOf(urlCross) }
    val enableDottedStroke = remember { mutableStateOf(false) }
    val strokeColor = remember { mutableStateOf(Color.Black) }

    val dndTarget = remember {
        object : DragAndDropTarget {
            override fun onDrop(event: DragAndDropEvent): Boolean {
                val draggedData = event.toAndroidDragEvent().clipData.getItemAt(0).text
                if (draggedData.toString() == isEgyptian.toString()) {
                    onGiveResult(urlCheck) //Correcto
                } else if (draggedData.toString() != isEgyptian.toString()) {
                    onGiveResult(urlCross) //Incorrecto
                }
                strokeColor.value = Color.Black
                return true
            }

            override fun onStarted(event: DragAndDropEvent) {
                super.onStarted(event)
                enableDottedStroke.value = true //Agregar cambio a contorno punteado
            }

            override fun onEnded(event: DragAndDropEvent) {
                super.onEnded(event)
                enableDottedStroke.value = false //Quitar cambio a contorno punteado
            }

            override fun onEntered(event: DragAndDropEvent) {
                super.onEntered(event)
                strokeColor.value = Color.Green //Cambio de color de contorno
            }

            override fun onExited(event: DragAndDropEvent) {
                super.onExited(event)
                strokeColor.value = Color.Black //Cambio de color de contorno
            }
        }
    }

    Box(modifier = Modifier//.background(Color.Red)
        .size(120.dp)
        .padding(12.dp)
        .drawBehind {
            val stroke = if (!enableDottedStroke.value) {
                Stroke()
            } else {
                Stroke(
                    width = 2f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                )
            }
            drawRoundRect(color = strokeColor.value, style = stroke)
        }
        .dragAndDropTarget(
            shouldStartDragAndDrop = { event ->
                event
                    .mimeTypes()
                    .contains(ClipDescription.MIMETYPE_TEXT_PLAIN)
            },
            target = dndTarget
        ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = textInBox,
            textAlign = TextAlign.Center
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DragImage(url: String) {
    AsyncImage(model = url,
        contentDescription = "Dragged Image",
        modifier = Modifier.dragAndDropSource {
            detectTapGestures(
                onLongPress = {
                    startTransfer(
                        DragAndDropTransferData(
                            ClipData.newPlainText("image uri", url)
                        )
                    )
                }
            )
        }
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DropTargetImage(url: String) {
    val urlState = remember {
        mutableStateOf(url)
    }
    var tintColor by remember {
        mutableStateOf(Color(0xffE5E4E2))
    }


    val dndTarget = remember {
        object : DragAndDropTarget {
            override fun onDrop(event: DragAndDropEvent): Boolean {
                val draggedData = event.toAndroidDragEvent().clipData.getItemAt(0).text
                urlState.value = draggedData.toString()
                return true
            }

            override fun onStarted(event: DragAndDropEvent) {
                super.onStarted(event)

            }

            override fun onEntered(event: DragAndDropEvent) {
                super.onEntered(event)
                tintColor = Color(0xff00ff00)
            }

            override fun onEnded(event: DragAndDropEvent) {
                super.onEntered(event)
                tintColor = Color(0xFFFF5722)
            }

            override fun onExited(event: DragAndDropEvent) {
                super.onEntered(event)
                tintColor = Color(0xffE5E4E2)
            }


        }
    }

    AsyncImage(
        model = urlState.value,
        contentDescription = "Dropped Image",
        colorFilter = ColorFilter.tint(
            color = tintColor,
            blendMode = BlendMode.Modulate
        ),
        modifier = Modifier
            .dragAndDropTarget(
                shouldStartDragAndDrop = { event ->
                    event
                        .mimeTypes()
                        .contains(ClipDescription.MIMETYPE_TEXT_PLAIN)
                },
                target = dndTarget
            )
    )
}

@Composable
fun BuildingInstructionCard(){
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
            text = "Arrastra las herramientas a la cultura que pertenece y descubre si es la correcta.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
            textAlign = TextAlign.Justify
        )
    }
}