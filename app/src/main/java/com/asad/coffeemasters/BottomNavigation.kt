package com.asad.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asad.coffeemasters.ui.theme.Alternative1
import com.asad.coffeemasters.ui.theme.OnPrimary

data class NavigationPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    var MenuPage = NavigationPage("Menu", Icons.Outlined.Menu, "menu")
    var OffersPage = NavigationPage("Offers", Icons.Outlined.Star, "offers")
    var OrdersPage = NavigationPage("My Order", Icons.Outlined.ShoppingCart, "order")
    var InfoPage = NavigationPage("Info", Icons.Outlined.Info, "info")

    var pages = listOf<NavigationPage>(MenuPage, OffersPage, OrdersPage, InfoPage)
}

@Preview
@Composable
fun NavBarItem_Preview() {
    NavBarItem(page = Routes.MenuPage,
    modifier = Modifier.padding(8.dp))
}

@Composable
fun NavBar(selectedRoute: String = Routes.MenuPage.route,
                onChange: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)
    ) {
        for (page in Routes.pages) {
            NavBarItem(page = page,
                selected = selectedRoute == page.route,
                modifier = Modifier.clickable {
                    onChange(page.route)
                }
            )
        }
    }

}

@Composable
fun NavBarItem(page: NavigationPage, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Alternative1 else OnPrimary
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) Alternative1 else OnPrimary
        )
    }
}