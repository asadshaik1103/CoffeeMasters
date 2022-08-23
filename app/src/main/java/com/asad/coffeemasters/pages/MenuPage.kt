package com.asad.coffeemasters.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.asad.coffeemasters.DataManager
import com.asad.coffeemasters.Product
import com.asad.coffeemasters.ui.theme.Alternative1
import com.asad.coffeemasters.ui.theme.CardBackground
import com.asad.coffeemasters.ui.theme.Primary

@Composable
fun MenuPage(dataManager: DataManager) {
    LazyColumn {
//        item {
//            Text("${dataManager.menu.count()}")
//        }

        items(dataManager.menu) {
            Text(text = it.name,
                color= Primary,
                modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 10.dp)
            )
            it.products.forEach { product ->
                Card(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .background(CardBackground)
                        .padding(vertical = 10.dp)
                        .padding(horizontal = 5.dp)

                ) {
                    ProductItem(product =product, onAdd = {
                        dataManager.cartAdd(product)
                    })
                }
            }
        }
//        items(5) {
//
//        }
    }
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)
//
//@Preview
//@Composable
//fun ProductItem_Preview() {
//    ProductItem(product = Product(1, "Dummy product", 24.7, ""), onAdd = {})
//}

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$${product.price.format(2)} ea")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Alternative1,
                    contentColor = Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}