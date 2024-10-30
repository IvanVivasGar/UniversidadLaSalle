package com.example.barcodeapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.barcodeapp.models.Product
import com.example.barcodeapp.utils.products

@Composable
fun ProductCard(product: Product){
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 4.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(6.dp)
        ){
            AsyncImage(model = product.image,
                contentDescription = product.name,
                modifier = Modifier.size(64.dp))
            Text(
                text = product.name,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.weight(1f))
            Text(
                text = "$${product.price}",
                color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Preview
@Composable
fun ProductCardPreview(){
    ProductCard(product = products[0])
}