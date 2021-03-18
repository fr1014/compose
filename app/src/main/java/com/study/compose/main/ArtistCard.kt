package com.study.compose.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.R
import com.study.compose.ui.theme.Shapes

@Composable
fun ArtistCard(onClick: () -> Unit) {
    val image = ImageBitmap.imageResource(id = R.drawable.header)
    val padding = 16.dp
    Column(
        Modifier
            .clickable(onClick = onClick)
            .padding(padding)
            .fillMaxWidth()
            .clip(shape = Shapes.large)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(bitmap = image, contentDescription = null)
        }
        Spacer(modifier = Modifier.padding(padding))
        Card(elevation = 4.dp) {

        }
    }
}

//@Composable
//fun ArtistCard() {
//    val image = ImageBitmap.imageResource(id = R.drawable.header)
//    val padding = 16.dp
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Image(bitmap = image, contentDescription = null)
//        Column(modifier = Modifier.padding(padding)) {
//            Text(text = "compose")
//            Text(text = "学习第一天")
//        }
//        Column(modifier = Modifier.padding(padding)) {
//            Text(text = "compose")
//            Text(text = "学习第二天")
//        }
//    }
//}

@Preview()
@Composable
fun ArtistDefaultPreview() {
    ArtistCard(onClick = { /*TODO*/ })
}
