package com.study.compose.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.study.compose.HelloViewModel
import com.study.compose.R

@Composable
fun MainAppBar() {
    TopAppBar(elevation = 0.dp, modifier = Modifier.height(80.dp)) {
    }
}

@Composable
fun NewsStory() {
    val image = ImageBitmap.imageResource(id = R.drawable.header)
    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifier = Modifier
                .height(180.dp)
                .fillMaxWidth() //指定图片的宽度应足以填充所属布局
                .clip(shape = RoundedCornerShape(16.dp)) //使用 clip() 函数对图片的四角进行圆角化处理
            Image(
                bitmap = image,
                contentDescription = null,
                modifier = imageModifier,
                contentScale = ContentScale.Crop //指定图片应填充 Column 的整个宽度，并根据需要剪裁为适当的高度。
            )
            Spacer(modifier = Modifier.height(16.dp)) //将图片与标题分开
            Text("A day in Shark Fin Cove",fontStyle = FontStyle.Normal)
            Text("Davenport, California")
            Text("December 2021")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsStory()
}
