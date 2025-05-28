package com.cssun.shoping.ui.theme.shop


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cssun.shoping.R


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
        name = "cleansera",
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


@Composable
fun ShopScreen(paddingValues: PaddingValues) {
    val listState = rememberLazyListState()
    val seeAll = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(Color(0xFF2C2C2C))
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        TopBar()
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            item {

                Column {
                    if (!seeAll.value) {
                        OffersScreenPreview()
                        CategoriesSection()
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .padding(bottom = 10.dp, top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "New Products",
                            color = Color.White,
                            fontSize = 28.sp,
                            fontFamily = FontFamily(Font(R.font.century))
                        )
                        Text(
                            text = if (!seeAll.value) "See all" else "Compact View",
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                seeAll.value = !seeAll.value
                            }
                        )
                    }
                }
            }
            items(productList) { product ->
                ProductCard(product)
            }

        }
    }
}
