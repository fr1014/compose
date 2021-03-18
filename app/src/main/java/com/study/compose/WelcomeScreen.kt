package com.study.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.ui.theme.ComposeTheme

@Composable
fun WelcomeScreen(darkTheme: Boolean = isSystemInDarkTheme(), navigateTo: (Screen) -> Unit) {

    val img_logo = if (darkTheme) {
        R.drawable.ic_dark_logo
    } else {
        R.drawable.ic_light_logo
    }

    val img_welcome_bg = if (darkTheme) {
        R.drawable.ic_dark_welcome_bg
    } else {
        R.drawable.ic_light_welcome_bg
    }

    val img_welcome_illos =
        if (darkTheme) {
            R.drawable.ic_dark_welcome_illos
        } else {
            R.drawable.ic_light_welcome_illos
        }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = img_welcome_bg),
            contentDescription = null
        )

        Column {
            Spacer(modifier = Modifier.height(72.dp))

            Image(
                imageVector = ImageVector.vectorResource(id = img_welcome_illos),
                contentDescription = null,
                modifier = Modifier.padding(start = 88.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            Image(
                imageVector = ImageVector.vectorResource(id = img_logo),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Beautiful home graden solutions",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {}, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(shape = MaterialTheme.shapes.large),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text(text = "Create Account")
            }
            
            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Log in",style = MaterialTheme.typography.button,modifier = Modifier.align(Alignment.CenterHorizontally).clickable { navigateTo(Screen.Login) })
        }
    }
}

@Preview
@Composable
fun PreviewWelcomeScreenLight() {
    ComposeTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            WelcomeScreen(darkTheme = false) {}
        }
    }
}