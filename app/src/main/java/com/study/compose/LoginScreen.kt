package com.study.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.study.compose.ui.theme.ComposeTheme

@Composable
fun LoginScreen(darkTheme: Boolean = isSystemInDarkTheme(), navigateTo: (Screen) -> Unit) {
    Column(modifier = Modifier.fillMaxHeight()) {

        Spacer(modifier = Modifier.height(184.dp))

        Text(
            text = "Login with email", style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.align(Alignment.CenterHorizontally), fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Email Address")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Password(8+ Characters)")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )

        Text(
            text = "By clicking below, you agree to our Terms of Use and consent \n to our Privacy Policy.",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 16.dp)
        )

        Button(
            onClick = {
                navigateTo(Screen.Home)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(48.dp)
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
                .clip(shape = MaterialTheme.shapes.large),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(text = "Log in", style = MaterialTheme.typography.button)
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewLoginLight() {

    ComposeTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            LoginScreen(darkTheme = false) {}
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewLoginDark() {

    ComposeTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            LoginScreen(darkTheme = true) {}
        }
    }
}