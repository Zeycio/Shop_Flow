package com.cssun.shoping.ui.theme.shop

import com.cssun.shoping.R


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


val productList = listOf(
    Product(
        name = "glow",
        description = "French clay and algae-powered cleanser",
        oprice = "444.00",
        dprice = "355.20",
        tag1 = "Skin Tightness",
        tag2 = "Dry & Dehydrated",
        rating = 5,
        imageUrl = R.drawable.product_image,
        reviewsCount = 249,
        inStock = true,
        bestSeller = true,
        favourite = true
    ),
    Product(
        name = "clensera",
        description = "Deep pore cleansing solution",
        oprice = "300.00",
        dprice = "250.00",
        tag1 = "Oily Skin",
        tag2 = "Pore Minimizing",
        rating = 4,
        imageUrl = R.drawable.categorysample,
        reviewsCount = 180,
        inStock = true,
        bestSeller = false,
        favourite = true
    ),
    Product(
        name = "afterglow",
        description = "Hydrating night repair serum",
        oprice = "550.00",
        dprice = "490.50",
        tag1 = "Hydration",
        tag2 = "Night Care",
        rating = 5,
        imageUrl = R.drawable.categorysample,
        reviewsCount = 310,
        inStock = false,
        bestSeller = true,
        favourite = false
    ),
    Product(
        name = "BlushBloom",
        description = "Silky smooth long-lasting blush",
        oprice = "799.00",
        dprice = "699.00",
        tag1 = "Makeup",
        tag2 = "Blush",
        rating = 4,
        imageUrl = R.drawable.makeup, // Replace with your actual drawable
        reviewsCount = 218,
        inStock = true,
        bestSeller = false,
        favourite = true
    ),
    Product(
        name = "AquaMist",
        description = "Deep hydration daily moisturiser",
        oprice = "650.00",
        dprice = "580.00",
        tag1 = "Hydration",
        tag2 = "Day Cream",
        rating = 5,
        imageUrl = R.drawable.moi,
        reviewsCount = 452,
        inStock = true,
        bestSeller = true,
        favourite = false
    ),
    Product(
        name = "SunGuard SPF 50",
        description = "Lightweight non-greasy sunscreen",
        oprice = "550.00",
        dprice = "495.00",
        tag1 = "Sun Protection",
        tag2 = "SPF 50",
        rating = 4,
        imageUrl = R.drawable.sun,
        reviewsCount = 300,
        inStock = true,
        bestSeller = false,
        favourite = true
    )
)
