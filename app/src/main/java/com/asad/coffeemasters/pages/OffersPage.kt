package com.asad.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asad.coffeemasters.ui.theme.Alternative1

//@Preview(showBackground = true)
//@Composable
//fun OffersSection() {
//    Column(
//        modifier = Modifier.verticalScroll(rememberScrollState())
//    ) {
//        Offer(title = "Offer 1", description = "description for offer 1")
//        Offer(title = "Offer 2", description = "description for offer 2")
//        Offer(title = "Offer 2", description = "description for offer 2")
//    }
//}
@Preview(showBackground = true)
@Composable
fun OffersPage() {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        Offer(title = "Early Coffe", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")

    }
}

@Composable
fun Offer(title: String, description: String) {
    val style = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(painter = painterResource(R.drawable.background_pattern),
            contentDescription = "background image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative1)
            )
            Text(text = description,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative1)
            )
        }
    }

}