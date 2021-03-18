package com.study.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.ui.theme.ComposeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun HomeScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    Scaffold(bottomBar = { BottomNavigation() }) {
        Column {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Search") },
                leadingIcon = {
                    Image(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                    )
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
            )
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Browse themes",
                    modifier = Modifier.align(Alignment.BottomStart),
                    fontWeight = FontWeight.Black
                )
            }

            LazyRow(modifier = Modifier.padding(start = 8.dp, top = 8.dp)) {
                items(rowData.size) {
                    RowItem(modifier = Modifier.padding(start = 8.dp), itemInfo = rowData[it])
                }
            }

            Row(
                modifier = Modifier
                    .height(40.dp)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = "Design your home garden",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.Bottom)
                )
            }

//            Apparently, I have to include these imports
//            import androidx.compose.runtime.getValue
//            import androidx.compose.runtime.setValue
//            The auto imports don't automatically recommend it in the beta Android Studio 4.2
//
//            If you use livedata, then consider the below import
//
//            import androidx.compose.runtime.livedata.observeAsState
            var checkedSet by remember {
                mutableStateOf(emptySet<ItemInfo>())
            }
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(cloumnData.size) { it ->
                    val item = cloumnData[it]
                    ColumnItem(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth(),
                        itemInfo = item,
                        checked = item in checkedSet,
                        onCheckedChange = { isChecked ->
                            checkedSet = checkedSet.toMutableSet().apply {
                                if (isChecked) {
                                    add(item)
                                } else {
                                    remove(item)
                                }
                            }

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnItem(
    modifier: Modifier,
    itemInfo: ItemInfo,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(modifier = Modifier.height(64.dp)) {
        Image(
            bitmap = ImageBitmap.imageResource(id = itemInfo.image),
            contentDescription = itemInfo.description,
            modifier = Modifier
                .size(64.dp)
                .padding(bottom = 8.dp),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp)
        ) {
            Text(
                text = itemInfo.name, style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 8.dp, top = 8.dp)
            )
            Text(
                text = itemInfo.description, style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 8.dp, bottom = 8.dp)
            )
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 12.dp)
            )
            Divider(modifier = Modifier.align(Alignment.BottomStart))
        }
    }
}

@Composable
fun RowItem(modifier: Modifier, itemInfo: ItemInfo) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(144.dp)
            .border(0.5.dp, Color.Gray, shape = MaterialTheme.shapes.small)
            .shadow(4.dp)
    ) {
        Box {
            Image(
                bitmap = ImageBitmap.imageResource(id = itemInfo.image),
                contentDescription = itemInfo.description,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            )
            Text(
                text = itemInfo.name,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp)
            )
        }
    }
}

@Composable
fun BottomNavigation() {
    val (current, setCurrent) = remember { mutableStateOf(navigationItem[0]) }
    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(16.dp)
    ) {
        navigationItem.forEach { item ->
            BottomNavigationItem(
                label = { Text(text = item.first) },
                icon = { Icon(item.second, null) },
                selected = current == item,
                onClick = { setCurrent(item) },
                // alwaysShowLabels is used to set if you want to show the labels always or just for the current item.
                alwaysShowLabel = true
            )

        }
    }
}

@Preview
@Composable
fun PreviewHomeScreenLight() {
    ComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            HomeScreen(darkTheme = false)
        }
    }
}