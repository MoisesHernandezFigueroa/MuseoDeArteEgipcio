package com.example.museodearteegipcio.views

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.museodearteegipcio.R

@Preview
@Composable
fun DressingView() {
    // Lista de prendas de ropa
    val dressList = listOf(
        // Prendas de vestir típicas de la cultura egipcia
        SingleDressInfo(
            name = "Kalasiris",
            picture = R.drawable.image_kalasiris,
            description = "Túnica larga y ajustada que era común entre mujeres egipcias de la nobleza."
        ),
        SingleDressInfo(
            name = "Shendyt",
            picture = R.drawable.image_shendyt,
            description = "Falda plisada que usaban los hombres, especialmente los trabajadores y soldados."
        ),
        SingleDressInfo(
            name = "Sandalias de Papiro",
            picture = R.drawable.image_sandalias_papiro,
            description = "Calzado tradicional hecho de hojas de papiro trenzadas."
        ),
        SingleDressInfo(
            name = "Collar Usekh",
            picture = R.drawable.image_collar_usekh,
            description = "Collar ancho y adornado que se llevaba como símbolo de estatus y protección."
        ),
        SingleDressInfo(
            name = "Nemes",
            picture = R.drawable.image_nemes,
            description = "Tocado a rayas usado por faraones, representando poder y autoridad."
        )
    )


    // Lista de prendas en una LazyColumn
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(dressList.size) {index ->
            SingleDressView(dress = dressList[index])
        }

    }
}

@Composable
fun SingleDressView(dress: SingleDressInfo) {
    var showDetails by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp)
            .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text(
            text = dress.name,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                //.background(Color.Green),

        ) {
            Box(
                modifier = Modifier.wrapContentWidth()
                    .padding(top = 10.dp),
                contentAlignment = Alignment.BottomEnd,
            ) {
                // Imagen principal
                Image(
                    painter = painterResource(id = dress.picture), // Cambia por tu recurso
                    contentDescription = null,
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Crop,
                )

                // Ícono circular
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .wrapContentSize() // Tamaño del círculo
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable { showDetails = !showDetails },
                    contentAlignment = Alignment.Center // Centrar el contenido
                ) {
                    Icon(
                        imageVector = if (showDetails) Icons.Default.KeyboardArrowLeft else Icons.Default.KeyboardArrowRight,
                        contentDescription = "Añadir",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp) // Tamaño del ícono
                    )
                }
            }

                AnimatedVisibility(
                    visible = showDetails,
                    enter = fadeIn(animationSpec = tween(durationMillis = 1500)) +
                            expandHorizontally(animationSpec = tween(durationMillis = 1500)),
                    exit = fadeOut(animationSpec = tween(durationMillis = 1500)) +
                            shrinkHorizontally(animationSpec = tween(durationMillis = 1500))
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = dress.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
        }
    }

}

//@Preview
@Composable
fun ImageWithIcon() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Altura para la imagen
            .padding(16.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray) // Fondo gris claro como placeholder
        ) {
            // Referencias para los elementos
            val (image, icon) = createRefs()

            // Imagen principal
            Image(
                painter = painterResource(id = R.drawable.image_pyramids), // Cambia por tu recurso
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxSize()
            )

            // Ícono circular
            Box(
                modifier = Modifier
                    .size(48.dp) // Tamaño del círculo
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable { /* Acción del ícono */ }
                    .constrainAs(icon) {
                        end.linkTo(parent.end, margin = 16.dp) // Márgen derecho
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                contentAlignment = Alignment.Center // Centrar el contenido
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp) // Tamaño del ícono
                )
            }
        }
    }
}

// Data class que representa una prenda
data class SingleDressInfo(
    val name: String,
    @DrawableRes val picture: Int,
    val description: String
)