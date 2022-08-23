package com.asad.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.asad.coffeemasters.pages.InfoPage
import com.asad.coffeemasters.pages.MenuPage
import com.asad.coffeemasters.pages.OrderPage

//@Preview
//@Composable
//fun App_Preview() {
//    CoffeeMastersTheme {
//        App()
//    }
//}

@Composable
fun App(dataManager: DataManager) {
    var selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }
    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier.background(Color.Black)) {
                AppTitle()
            }

        },
        content = {
            when(selectedRoute.value) {
                Routes.MenuPage.route -> MenuPage(dataManager)
                Routes.OffersPage.route -> OffersPage()
                Routes.OrdersPage.route -> OrderPage(dataManager)
                Routes.InfoPage.route -> InfoPage()
            }
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = {
                selectedRoute.value = it
            })
        }
    )
}

@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo description")
    }
}