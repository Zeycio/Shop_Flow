package com.cssun.shoping.ui.theme.shop


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cssun.shoping.R


data class Category(
    val name: String,
    val imageResId: Int? = null,
    val imageVector: androidx.compose.ui.graphics.vector.ImageVector? = null
)

@Composable
fun CategoryItem(category: Category) {
    val darkCircleBackground = Color(0xFF1B1B1B)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(darkCircleBackground),
            contentAlignment = Alignment.Center
        ) {
            if (category.imageResId != null) {
                Image(
                    painter = painterResource(id = category.imageResId),
                    contentDescription = category.name,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Crop
                )
            } else if (category.imageVector != null) {
                Icon(
                    imageVector = category.imageVector,
                    contentDescription = category.name,
                    tint = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier.size(60.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Missing image for ${category.name}",
                    tint = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier.size(60.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = category.name,
            color = Color.White,
            fontSize = 14.sp,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun CategoriesSection() {
    val categories = listOf(
        Category("Cleaners", imageResId = R.drawable.face),
        Category("Toner", imageResId = R.drawable.toner),
        Category("Makeup", imageResId = R.drawable.makeup),
        Category("Moisturisers", imageResId = R.drawable.moi,),
        Category("Sunscreens", imageResId = R.drawable.sun),
        Category("Masks", imageResId = R.drawable.categorysample),
    )

     val  seeAll =  remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2C2C2C))
            .padding( horizontal = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp,top =5.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categories",
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
        if(!seeAll.value) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(categories) { category ->
                    CategoryItem(category = category)
                }
            }
        }else{
            LazyColumn(
                modifier = Modifier.fillMaxWidth().height(500.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(categories) { category ->
                    CategoryItem(category = category)
                }
            }
        }
    }
}