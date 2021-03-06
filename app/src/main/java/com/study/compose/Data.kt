package com.study.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart

data class ItemInfo(
    val image: Int = R.drawable.ic_launcher_foreground,
    val name: String = "",
    val description: String = "This is a description"
)

val rowData = listOf<ItemInfo>(
    ItemInfo(name = "Desert chic", image = R.drawable.desert_chic),
    ItemInfo(name = "Tiny terrariums", image = R.drawable.tiny_terrariums),
    ItemInfo(name = "Jungle vibes", image = R.drawable.jungle_vibes),
    ItemInfo(name = "Easy care", image = R.drawable.easy_care),
    ItemInfo(name = "Statements", image = R.drawable.statements)
)

val cloumnData = listOf<ItemInfo>(
    ItemInfo(name = "Monstera", image = R.drawable.monstera),
    ItemInfo(name = "Aglaonema", image = R.drawable.aglaonema),
    ItemInfo(name = "Peace lily", image = R.drawable.peace_lily),
    ItemInfo(name = "Fiddle leaf tree", image = R.drawable.fiddle_leaf_tree),
    ItemInfo(name = "Snake plant", image = R.drawable.snake_plant),
    ItemInfo(name = "Pothos", image = R.drawable.pothos),

    )

val navigationItem = listOf(
    "Home" to Icons.Default.Home,
    "Favorites" to Icons.Default.FavoriteBorder,
    "Profile" to Icons.Default.AccountCircle,
    "Cart" to Icons.Default.ShoppingCart,
)