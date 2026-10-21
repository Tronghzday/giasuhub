package com.example.giasuhub
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true   // bắt buộc cho localStorage
        webView.webViewClient = WebViewClient()       // giữ mọi thứ trong app
        webView.loadUrl("file:///android_asset/index.html")
    }

    // Bấm nút Back sẽ lùi trong lịch sử WebView thay vì thoát app ngay
    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }
}