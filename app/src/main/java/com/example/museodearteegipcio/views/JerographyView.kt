package com.example.museodearteegipcio.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.museodearteegipcio.R
import com.example.museodearteegipcio.navigation.ScreenRoutes

@Composable
fun JerographyView() {

        val context = LocalContext.current
        // set up all transformation states
        var scale by remember { mutableStateOf(1f) }
        var rotation by remember { mutableStateOf(0f) }
        var offset by remember { mutableStateOf(Offset.Zero) }

        val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
            scale *= zoomChange
            rotation += rotationChange
            offset += offsetChange
        }
        Box(contentAlignment = Alignment.TopStart)
        {
            Text(
                text = "Recuerda hacer zoom para ver los detalles",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )

            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.jeroglificos),
                    contentDescription = "jeroglificos",
                    Modifier
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            //rotationZ = rotation,
                            translationX = offset.x,
                            translationY = offset.y
                        )
                        // add transformable to listen to multitouch transformation events
                        // after offset
                        .transformable(state = state)
                    //.background(Color.Blue)
                    ,contentScale = ContentScale.Fit)
            }

            Column(modifier = Modifier.fillMaxSize().padding(bottom = 10.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally) {
                FloatingActionButton(onClick = {
                    scale = 1f
                    offset = Offset.Zero
                    //Toast.makeText(context, "Regresa al inicio", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = "refresh")
                }
            }

        }
    }
