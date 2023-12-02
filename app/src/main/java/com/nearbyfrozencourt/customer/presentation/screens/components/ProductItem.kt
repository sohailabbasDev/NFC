package com.nearbyfrozencourt.customer.presentation.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nearbyfrozencourt.customer.data.remote.dto.ProductDetailsDto

@Composable
fun ProductItem(product : ProductDetailsDto.Data) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp)
            .padding(top = 14.dp)
            .wrapContentHeight()
            .clickable {  },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(6.dp),
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .defaultMinSize(minHeight = 42.dp, minWidth = 42.dp)
                    .padding(all = 12.dp)
                    .clip(shape = RoundedCornerShape(6.dp)),
                model = ImageRequest.Builder(LocalContext.current).data(product.image_url).build(),
                contentDescription = "image"
            )
            Column(
                modifier = Modifier
                    .wrapContentSize()
//                verticalArrangement = Arrangement.SpaceEvenly,
//                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    text = product.name,
                    overflow = TextOverflow.Ellipsis,
//                    softWrap = true,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 8.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ){
//
//                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    text = "₹${product.product_variations[0].variations[0].sell_price_inc_tax} incl. tax",
                    overflow = TextOverflow.Ellipsis,
//                    softWrap = true,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(6.dp))
                if (!product.product_description.isNullOrBlank()){
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
//                    softWrap = false,
//                    overflow = TextOverflow.Ellipsis,
                        maxLines = 100,
                        text = product.product_description,
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black.copy(0.7f), fontWeight = FontWeight.ExtraLight)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}