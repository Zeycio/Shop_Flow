package com.cssun.shoping.ui.theme.shop


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cssun.shoping.R


@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2C2C2C))
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .paperBackground()
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                var favstate = remember { mutableStateOf(product.favourite) }
                Button(
                    onClick = { favstate.value = !favstate.value },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier
                        .padding(bottom = 15.dp, end = 15.dp)
                        .size(50.dp)
                        .align(alignment = Alignment.TopStart),
                    contentPadding = PaddingValues(10.dp)
                ) {
                    Icon(
                        imageVector = if (favstate.value) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Add ${product.name} to cart",
                        tint = if (favstate.value) Color(0xFF7A64F5) else Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                }
                if (product.bestSeller) {
                    OutlinedButton(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.TopEnd)
                            .padding(top = 10.dp, end = 10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        onClick = {}) {
                        Text(
                            "Best Seller",
                            color = Color(0xFF8BC34A)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .background(Color.Transparent)
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = product.imageUrl),
                        contentDescription = product.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 10.dp)
                            .height(350.dp),
                        contentScale = ContentScale.FillHeight
                    )
                    Card(
                        modifier = Modifier
                            .padding(bottom = 15.dp)
                            .paperBackgroundBottomRightTear(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Transparent),

                        ) {
                        Column(
                            Modifier
                                .padding(10.dp)
                                .background(Color.Transparent)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = product.name,
                                    fontFamily = FontFamily(Font(R.font.tangerine)),
                                    fontSize = 22.sp,
                                    color = Color(0xFF8BC34A)
                                )
                                if (product.inStock) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Box(
                                            modifier = Modifier
                                                .size(8.dp)
                                                .background(Color(0xFF8BC34A), shape = CircleShape)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "In stock",
                                            fontSize = 12.sp,
                                            color = Color(0xFF8BC34A)
                                        )
                                    }
                                } else {
                                    Text(
                                        text = "Out of stock",
                                        fontSize = 12.sp,
                                        color = Color.Red.copy(alpha = 0.7f),
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                            Text(
                                text = product.description,
                                fontSize = 14.sp,
                                color = Color.LightGray,
                                modifier = Modifier.padding(top = 4.dp),
                                maxLines = 2
                            )
                            Text(
                                text = "${product.tag1} • ${product.tag2}",
                                fontSize = 13.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 12.dp, bottom = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Row(verticalAlignment = Alignment.Bottom) {
                                        Text(
                                            text = "RS. ${product.dprice}",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 20.sp,
                                            color = Color.White
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "RS. ${product.oprice}",
                                            fontSize = 14.sp,
                                            color = Color.Gray,
                                            textDecoration = TextDecoration.LineThrough
                                        )
                                    }
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(top = 4.dp)
                                    ) {
                                        repeat(5) { index ->
                                            Icon(
                                                imageVector = if (index < product.rating) Icons.Filled.Star else Icons.Outlined.Star,
                                                contentDescription = "Star",
                                                tint = if (index < product.rating) Color(0xFFFFC107) else Color.Gray,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }
                                        product.reviewsCount?.let { count ->
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "$count reviews",
                                                fontSize = 12.sp,
                                                color = Color.LightGray
                                            )
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
                OutlinedButton(
                    onClick = { /* TODO: Handle add to cart for product.name */ },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    border = _root_ide_package_.androidx.compose.foundation.BorderStroke(
                        2.dp,
                        Color(0xFF8BC34A)
                    ),
                    modifier = Modifier
                        .padding(bottom = 15.dp, end = 15.dp)
                        .size(50.dp)
                        .align(alignment = Alignment.BottomEnd),
                    contentPadding = PaddingValues(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "Add ${product.name} to cart",
                        tint = Color(0xFF8BC34A),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}


fun Modifier.paperBackground(
    cornerRadius: Dp = 24.dp,
    tearStartOnLeftY: Dp = 60.dp,
    tearPeakX: Dp = 50.dp,
    tearPeakY: Dp = 70.dp,
    tearEndOnTopX: Dp = 60.dp,
    gradientStartColor: Color = Color(0xFFD5CCCC),
    gradientEndColor: Color = Color(0xFF312F2F)
): Modifier = this.drawBehind {
    val pxCornerRadius = cornerRadius.toPx()
    val pxTearStartOnLeftY = tearStartOnLeftY.toPx()
    val pxTearPeakX = tearPeakX.toPx()
    val pxTearPeakY = tearPeakY.toPx()
    val pxTearEndOnTopX = tearEndOnTopX.toPx()

    val paperPath = Path().apply {
        moveTo(pxTearEndOnTopX, 0f)
        lineTo(size.width - pxCornerRadius, 0f)
        arcTo(
            rect = Rect(
                Offset(size.width - 2 * pxCornerRadius, 0f),
                Size(2 * pxCornerRadius, 2 * pxCornerRadius)
            ),
            startAngleDegrees = 270f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        lineTo(size.width, size.height - pxCornerRadius)
        arcTo(
            rect = Rect(
                Offset(size.width - 2 * pxCornerRadius, size.height - 2 * pxCornerRadius),
                Size(2 * pxCornerRadius, 2 * pxCornerRadius)
            ),
            startAngleDegrees = 0f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        lineTo(pxCornerRadius, size.height)

        arcTo(
            rect = Rect(
                Offset(0f, size.height - 2 * pxCornerRadius),
                Size(2 * pxCornerRadius, 2 * pxCornerRadius)
            ),
            startAngleDegrees = 90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )

        lineTo(0f, pxTearStartOnLeftY)
        val control1X =
            pxTearEndOnTopX * 0.2f
        val control1Y =
            pxTearStartOnLeftY + (pxTearPeakY * 0.1f)
        val control2X =
            pxTearPeakX * 1.5f
        val control2Y = pxTearPeakY * 1.0f

        cubicTo(
            x1 = control1X,
            y1 = control1Y,
            x2 = control2X,
            y2 = control2Y,
            x3 = pxTearEndOnTopX,
            y3 = 0f
        )

        close()
    }


    drawPath(
        path = paperPath,
        brush = Brush.verticalGradient(
            colors = listOf(gradientStartColor, gradientEndColor),
            startY = 0f,
            endY = size.height
        )
    )
}

fun Modifier.paperBackgroundBottomRightTear(
    cornerRadius: Dp = 24.dp,
    tearStartOnRightEdgeYOffset: Dp = 60.dp,
    tearEndOnBottomEdgeXOffset: Dp = 60.dp,
    tearPeakOffsetX: Dp = 50.dp,
    tearPeakOffsetY: Dp = 70.dp,
    gradientStartColor: Color = Color(0xFF000000),
    gradientEndColor: Color = Color(0xFF000000)
): Modifier = this.drawBehind {

    val pxCornerRadius = cornerRadius.toPx()
    val pxTearStartOnRightEdgeYOffset = tearStartOnRightEdgeYOffset.toPx()
    val pxTearEndOnBottomEdgeXOffset = tearEndOnBottomEdgeXOffset.toPx()
    val pxTearPeakOffsetX = tearPeakOffsetX.toPx()
    val pxTearPeakOffsetY = tearPeakOffsetY.toPx()

    val paperPath = Path().apply {
        moveTo(pxCornerRadius, 0f)
        lineTo(size.width - pxCornerRadius, 0f)
        arcTo(
            rect = Rect(
                Offset(size.width - 2 * pxCornerRadius, 0f),
                Size(2 * pxCornerRadius, 2 * pxCornerRadius)
            ),
            startAngleDegrees = 270f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )

        lineTo(size.width, size.height - pxTearStartOnRightEdgeYOffset)
        val control1X = size.width - (pxTearEndOnBottomEdgeXOffset * 0.2f)
        val control1Y = size.height - pxTearStartOnRightEdgeYOffset - (pxTearPeakOffsetY * 0.1f)
        val control2X = size.width - (pxTearPeakOffsetX * 1.5f)
        val control2Y = size.height - (pxTearPeakOffsetY * 1.0f)

        cubicTo(
            x1 = control1X,
            y1 = control1Y,
            x2 = control2X,
            y2 = control2Y,
            x3 = size.width - pxTearEndOnBottomEdgeXOffset,
            y3 = size.height
        )
        lineTo(pxCornerRadius, size.height)

        arcTo(
            rect = Rect(
                Offset(0f, size.height - 2 * pxCornerRadius),
                Size(2 * pxCornerRadius, 2 * pxCornerRadius)
            ),
            startAngleDegrees = 90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        lineTo(0f, pxCornerRadius)
        arcTo(
            rect = Rect(Offset(0f, 0f), Size(2 * pxCornerRadius, 2 * pxCornerRadius)),
            startAngleDegrees = 180f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )

        close()
    }
    drawPath(
        path = paperPath,
        brush = Brush.verticalGradient(
            colors = listOf(gradientStartColor, gradientEndColor),
            startY = 0f,
            endY = size.height
        )
    )
}