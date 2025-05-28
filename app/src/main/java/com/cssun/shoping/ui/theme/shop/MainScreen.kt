package com.cssun.shoping.ui.theme.shop


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cssun.shoping.R


@Composable
fun ShopScreen(paddingValues: PaddingValues) {
    val listState = rememberLazyListState()
    val isScrolling = listState.isScrollInProgress
    val  seeAll =  remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(Color(0xFF2C2C2C))
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        TopBar()

        // AnimatedVisibility for the content that should hide/show


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
                                text = if (!seeAll.value)"See all" else "Compact View",
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
