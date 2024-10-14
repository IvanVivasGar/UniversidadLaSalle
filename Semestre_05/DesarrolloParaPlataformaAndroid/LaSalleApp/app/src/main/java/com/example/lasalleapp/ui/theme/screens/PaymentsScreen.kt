package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.PaymentItem

@Composable
fun PaymentsScreen(innerPadding: PaddingValues) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background),
        state = scrollState
    ) {
        item {
            Text(text = "Pagos Pendientes",
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        }
        items(3) {
            PaymentItem()
        }

        item {
            Text(text = "Pagos Realizados",
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        }
        items(2) {
            PaymentItem()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PaymentsScreenPreview(){
    LaSalleAppTheme {
        PaymentsScreen(innerPadding = PaddingValues(0.dp))
    }
}