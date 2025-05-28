package com.cssun.shoping.ui.theme.shop

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OfferCard(
    offer: Offer,
    totalOffersCount: Int,
    currentPageIndex: Int
) {
    val cardBackgroundColor = Color(0xFF000000)
    val badgeGreen = Color(0xFF8BC34A)
    val inactiveDotColor = Color(0xFF505050)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(
                cardBackgroundColor,
                RoundedCornerShape(24.dp)
            )
            .padding(24.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = offer.title,
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = offer.subtitle,
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(16.dp))

                DateTag(dateRange = offer.dateRange, backgroundColor = badgeGreen)
            }

            offer.imageIcon()
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 0.dp, start = 0.dp)
                .background(Color.Transparent, RoundedCornerShape(50.dp))
                .border(
                    width = 1.dp,
                    color = inactiveDotColor,
                    shape = RoundedCornerShape(50.dp)
                )
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(totalOffersCount) { index ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 2.dp)
                        .size(8.dp)
                        .background(
                            color = if (index == currentPageIndex) badgeGreen else Color.Transparent,
                            shape = CircleShape
                        )
                        .then(
                            if (index != currentPageIndex) Modifier.border(
                                1.dp,
                                inactiveDotColor,
                                CircleShape
                            )
                            else Modifier
                        )
                )
            }
        }
    }
}

@Composable
fun DateTag(dateRange: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(backgroundColor, RoundedCornerShape(4.dp))
            .padding(horizontal = 8.dp, vertical = 1.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = dateRange,
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OffersScreenPreview() {
    MaterialTheme {
        Surface(color = Color(0xFF2C2C2C)) {
            val offers = remember {
                listOf(
                    Offer(
                        title = "GET 20% OFF",
                        subtitle = "Get 20% off on all products",
                        dateRange = "12-16 October",
                        imageIcon = {
                            Icon(
                                imageVector = Icons.Outlined.DateRange,
                                contentDescription = "Offer image placeholder",
                                tint = Color.White.copy(alpha = 0.5f),
                                modifier = Modifier
                                    .size(64.dp)

                            )
                        }
                    ),
                    Offer(
                        title = "FREE SHIPPING",
                        subtitle = "On orders over $50",
                        dateRange = "Ends 31 Oct",
                        imageIcon = {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "Shipping icon",
                                tint = Color.White.copy(alpha = 0.5f),
                                modifier = Modifier
                                    .size(64.dp)

                            )
                        }
                    ),
                    Offer(
                        title = "BUY 1 GET 1",
                        subtitle = "Select items only",
                        dateRange = "Valid until 5 Nov",
                        imageIcon = {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "Bag icon",
                                tint = Color.White.copy(alpha = 0.5f),
                                modifier = Modifier
                                    .size(64.dp)

                            )
                        }
                    )
                )
            }

            val pagerState = rememberPagerState(initialPage = 0) {
                offers.size
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    pageSpacing = 10.dp
                ) { page ->
                    OfferCard(
                        offer = offers[page],
                        totalOffersCount = offers.size,
                        currentPageIndex = page
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}