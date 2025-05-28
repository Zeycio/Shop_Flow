package com.cssun.shoping.ui.theme.shop

import androidx.compose.runtime.Composable



data class Product(
    val name: String,
    val description: String,
    val oprice: String,
    val dprice: String,
    val tag1: String,
    val tag2: String,
    val rating: Int,
    val imageUrl: Int,
    val reviewsCount: Int? = null,
    val inStock: Boolean = true,
    val bestSeller: Boolean = true,
    val favourite: Boolean = true,
)


data class Category(
    val name: String,
    val imageResId: Int? = null,
    val imageVector: androidx.compose.ui.graphics.vector.ImageVector? = null
)



data class Offer(
    val title: String,
    val subtitle: String,
    val dateRange: String,
    val imageIcon: @Composable () -> Unit
)