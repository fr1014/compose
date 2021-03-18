package com.study.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.study.compose.ui.theme.ComposeTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                MyApp()
            }
        }
    }
}

var extime: Long = 0

@Composable
fun ComposeActivity.MyApp() {
    //组合和重组 - 可组合项中的状态
    val (screen, setScreen) = remember { mutableStateOf(Screen.Welcome) }
    DisposableEffect(screen) {
        extime = 0
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                when (screen) {
                    Screen.Home -> {
                        if (System.currentTimeMillis() - extime > 2000) {
                            Toast.makeText(
                                this@MyApp,
                                "Press back agin to exit app",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            extime = System.currentTimeMillis()
                        } else {
                            this@MyApp.finish()
                        }
                    }
                    Screen.Login -> {
                        setScreen(Screen.Welcome)
                    }
                    else -> {
                        this@MyApp.finish()
                    }
                }
            }

        }
        this@MyApp.onBackPressedDispatcher.addCallback(callback)
        onDispose {
            callback.remove()
        }
    }

    Surface(color = MaterialTheme.colors.background) {
        when (screen) {
            Screen.Welcome -> WelcomeScreen(navigateTo = setScreen)
            Screen.Login -> LoginScreen(navigateTo = setScreen)
            Screen.Home -> HomeScreen()
        }
    }
}

enum class Screen {
    Welcome, Login, Home
}