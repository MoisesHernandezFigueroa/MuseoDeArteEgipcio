package com.example.museodearteegipcio.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun DrawerContent(navController: NavController, drawerState: DrawerState, scope: CoroutineScope) {
Column(modifier = Modifier
    .fillMaxSize()
    .background(MaterialTheme.colorScheme.primaryContainer)
    .padding(vertical = 16.dp)) {

    Text(text = "Descubrir Egipto",
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        modifier = Modifier.padding(horizontal = 16.dp))

    Divider()
    //HomeView
    CustomDrawerContent(
        icon = ScreenRoutes.HomeView.drawerItem.icon,
        label = ScreenRoutes.HomeView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.HomeView.route,
        drawerState = drawerState,
        scope = scope
    )
    //Primer submenu
    Text(text = "Vida cotidiana")
    Divider()
    ////DressingView
    CustomDrawerContent(
        icon = ScreenRoutes.DressingView.drawerItem.icon,
        label = ScreenRoutes.DressingView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.DressingView.route,
        drawerState = drawerState,
        scope = scope
    )
    //PetsView
    CustomDrawerContent(
        icon = ScreenRoutes.PetsView.drawerItem.icon,
        label = ScreenRoutes.PetsView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.PetsView.route,
        drawerState = drawerState,
        scope = scope
    )
    //WorkingView
    CustomDrawerContent(
        icon = ScreenRoutes.WorkingView.drawerItem.icon,
        label = ScreenRoutes.WorkingView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.WorkingView.route,
        drawerState = drawerState,
        scope = scope
    )

    //Segundo submenu
    Text(text = "Arquitectura")
    Divider()
    //TemplesView
    CustomDrawerContent(
        icon = ScreenRoutes.TemplesView.drawerItem.icon,
        label = ScreenRoutes.TemplesView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.TemplesView.route,
        drawerState = drawerState,
        scope = scope
    )
    //PyramidesView Linea del tiempo
    CustomDrawerContent(
        icon = ScreenRoutes.PyramidesView.drawerItem.icon,
        label = ScreenRoutes.PyramidesView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.PyramidesView.route,
        drawerState = drawerState,
        scope = scope
    )
    //FuneraryBuildingsView
    CustomDrawerContent(
        icon = ScreenRoutes.FuneraryBuildingsView.drawerItem.icon,
        label = ScreenRoutes.FuneraryBuildingsView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.FuneraryBuildingsView.route,
        drawerState = drawerState,
        scope = scope
    )
    //BuildingTechniquesView
    CustomDrawerContent(
        icon = ScreenRoutes.BuildingTechniquesView.drawerItem.icon,
        label = ScreenRoutes.BuildingTechniquesView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.BuildingTechniquesView.route,
        drawerState = drawerState,
        scope = scope
    )
    //Tercer submenu
    Text(text = "Arte")
    Divider()
    //SculptureView
    CustomDrawerContent(
        icon = ScreenRoutes.SculptureView.drawerItem.icon,
        label = ScreenRoutes.SculptureView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.SculptureView.route,
        drawerState = drawerState,
        scope = scope
    )
    //PaintingView
    CustomDrawerContent(
        icon = ScreenRoutes.PaintingView.drawerItem.icon,
        label = ScreenRoutes.PaintingView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.PaintingView.route,
        drawerState = drawerState,
        scope = scope
    )
    //JerographyView agregar imagen que se pueda pelliscar
    CustomDrawerContent(
        icon = ScreenRoutes.JerographyView.drawerItem.icon,
        label = ScreenRoutes.JerographyView.drawerItem.label,
        navController = navController,
        route = ScreenRoutes.JerographyView.route,
        drawerState = drawerState,
        scope = scope
    )
}
}

@Composable
fun CustomDrawerContent(
    icon: ImageVector,
    label : String,
    navController: NavController,
    route: String,
    drawerState: DrawerState,
    scope: CoroutineScope){
    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(24.dp)
            )
        },
        label = { Text(text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer) },
        selected = false,
        onClick = {
            navController.navigate(route) //Manda a llamar a la navegacion de otra pagina
            scope.launch {
                drawerState.close()
            }

        },
        modifier = Modifier.padding(2.dp),
        colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor =  MaterialTheme.colorScheme.primaryContainer)
    )
}