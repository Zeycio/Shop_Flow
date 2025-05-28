package com.cssun.shoping

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.cssun.shoping.ui.theme.ShopingTheme
import com.cssun.shoping.ui.theme.shop.ShopScreen

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ContextCastToActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding->
                    ShopScreen(innerPadding)
                }
            }
        }
    }
}

