package com.asad.coffeemasters.pages

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MyWebView() {
    var url = "https://github.com/asadshaik1103"

    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            webViewClient = WebViewClient() // customizes the web view
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
    
}

@Preview
@Composable
fun InfoPage() {
    MyWebView()
}