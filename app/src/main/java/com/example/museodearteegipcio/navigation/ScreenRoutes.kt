package com.example.museodearteegipcio.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.example.museodearteegipcio.R
import com.example.museodearteegipcio.icons.Art
import com.example.museodearteegipcio.icons.Building
import com.example.museodearteegipcio.icons.Dress
import com.example.museodearteegipcio.icons.Food
import com.example.museodearteegipcio.icons.Paint
import com.example.museodearteegipcio.icons.Pet
import com.example.museodearteegipcio.icons.Pyramid
import com.example.museodearteegipcio.icons.Sculpture
import com.example.museodearteegipcio.icons.Skull
import com.example.museodearteegipcio.icons.Temple
import com.example.museodearteegipcio.icons.Work

//Se crean los nombres y las rutas de las pantallas
sealed class ScreenRoutes {
    data object HomeView : ScreenRoutes() {
        val route = "HomeView"
        val drawerItem : DrawerItem = DrawerItem("Home", Icons.Default.Home)
    }

    data object DressingView : ScreenRoutes() {
        val route = "DressingView"
        val drawerItem : DrawerItem = DrawerItem("Vestimenta y moda", Icons.Dress)
    }

    data object FeedingView : ScreenRoutes() {
        val route = "FeedingView"
        val drawerItem : DrawerItem = DrawerItem("Alimentacion", Icons.Food)
    }

    data object WorkingView : ScreenRoutes() {
        val route = "WorkingView"
        val drawerItem : DrawerItem = DrawerItem("Trabajo y economia", Icons.Work)
    }

    data object PetsView : ScreenRoutes() {
        val route = "PetsView"
        val drawerItem : DrawerItem = DrawerItem("Fauna y mascotas", Icons.Pet)
    }

    data object TemplesView : ScreenRoutes() {
        val route = "TemplesView"
        val drawerItem : DrawerItem = DrawerItem("Templos", Icons.Temple)
    }

    data object PyramidesView : ScreenRoutes() {
        val route = "PyramidesView"
        val drawerItem : DrawerItem = DrawerItem("Piramides", Icons.Pyramid)
    }

    data object FuneraryBuildingsView : ScreenRoutes() {
        val route = "FuneraryBuildingsView"
        val drawerItem : DrawerItem = DrawerItem("Edificaciones funerarias", Icons.Skull)
    }

    data object BuildingTechniquesView : ScreenRoutes() {
        val route = "BuildingTechniquesView"
        val drawerItem : DrawerItem = DrawerItem("Tecnicas de contruccion", Icons.Building)
    }

    data object SculptureView : ScreenRoutes() {
        val route = "SculptureView"
        val drawerItem : DrawerItem = DrawerItem("Escultura", Icons.Sculpture)
    }

    data object PaintingView : ScreenRoutes() {
        val route = "PaintingView"
        val drawerItem : DrawerItem = DrawerItem("Pintura", Icons.Art)
    }

    data object JerographyView : ScreenRoutes() {
        val route = "JerographyView"
        val drawerItem : DrawerItem = DrawerItem("Jeroglificos", Icons.Paint)
    }


}

/*
//Lista de items en el Drawer
val drawerItems = listOf(
    DrawerItem("Home", Icons.Default.Home), //HomeView
    //Vida cotidiana
    DrawerItem("Vestimenta y moda", Icons.Default.Home), //DressingView
    DrawerItem("Mascotas", Icons.Default.Settings),//PetsView
    DrawerItem("Trabajo y economia", Icons.Default.Settings),//WorkingView
    DrawerItem("Alimentacion", Icons.Default.Person), //FeedingView

    //Arquitectura
    DrawerItem("Templos", Icons.Default.Home), //TemplesView
    DrawerItem("Piramides", Icons.Default.Person), //PyramidesView
    DrawerItem("Edificaciones funerarias", Icons.Default.Settings),//FuneraryBuildingsView
    DrawerItem("Tecnicas de contruccion", Icons.Default.Settings),//BuildingTechniquesView
    //Arte
    DrawerItem("Escultura", Icons.Default.Home),//SculptureView
    DrawerItem("Pintura", Icons.Default.Person),//PaintingView
    DrawerItem("Jeroglificos", Icons.Default.Settings),//JerographyView
)*/