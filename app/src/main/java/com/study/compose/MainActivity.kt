package com.study.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.study.compose.main.ArtistCard
import com.study.compose.main.NewsStory
import com.study.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    private val helloViewModel by viewModels<HelloViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ArtistCard(onClick = { /*TODO*/ })
                }
            }
        }
    }
}
