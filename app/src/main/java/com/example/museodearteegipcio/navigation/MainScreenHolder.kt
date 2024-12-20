package com.example.museodearteegipcio.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.museodearteegipcio.MainActivity
import com.example.museodearteegipcio.views.BuildingTechniquesView
import com.example.museodearteegipcio.views.DressingView
import com.example.museodearteegipcio.views.FuneraryBuildingsView
import com.example.museodearteegipcio.views.HomeView
import com.example.museodearteegipcio.views.JerographyView
import com.example.museodearteegipcio.views.PaintingView
import com.example.museodearteegipcio.views.PetsView
import com.example.museodearteegipcio.views.PyramidesView
import com.example.museodearteegipcio.views.SculptureView
import com.example.museodearteegipcio.views.TemplesView
import com.example.museodearteegipcio.views.WorkingView
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenHolder(activity: MainActivity) {


    //Valor nevcesario para manejar la navegación en compose
    val navController = rememberNavController()
    //Valores necesarios para manejar el drawer en Compose
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()



    //Se manda a llamar el drawer y dentro de este hay un Scaffold con Top Bar
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(navController, drawerState, scope) //Se manda a traer el Composable del drawer
            }
        },
        gesturesEnabled = false) {
        Scaffold(topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "Museo de Arte Egipcio") },
                navigationIcon = {
                    IconButton(onClick = {
                        //Abre el drawer (se utiliza corutinas)
                        scope.launch {
                            drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                })
        }) { innerPadding ->
            // Se agrega este box para asegurar que la llamada de pantalla se dentro del padding del Scaffold
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {

                //Contenido intercambiale y navegable con navController
                NavHost(navController = navController, startDestination = ScreenRoutes.HomeView.route) {
                    composable(route = ScreenRoutes.HomeView.route) {
                        HomeView()
                    }
                    composable(route = ScreenRoutes.DressingView.route) {
                        DressingView()
                    }
                    composable(route = ScreenRoutes.PetsView.route) {
                        PetsView()
                    }
                    composable(route = ScreenRoutes.WorkingView.route) {
                        WorkingView()
                    }
                    composable(route = ScreenRoutes.TemplesView.route) {
                        TemplesView()
                    }
                    composable(route = ScreenRoutes.PyramidesView.route) {
                        PyramidesView(activity)
                    }
                    composable(route = ScreenRoutes.FuneraryBuildingsView.route) {
                        FuneraryBuildingsView()
                    }
                    composable(route = ScreenRoutes.BuildingTechniquesView.route) {
                        BuildingTechniquesView()
                    }
                    composable(route = ScreenRoutes.SculptureView.route) {
                        SculptureView()
                    }
                    composable(route = ScreenRoutes.PaintingView.route) {
                        PaintingView()
                    }
                    composable(route = ScreenRoutes.JerographyView.route) {
                        JerographyView()
                    }
                }
            }

        }
    }
}