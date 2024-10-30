package com.example.barcodeapp.ui.screens

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barcodeapp.models.Product
import com.example.barcodeapp.ui.components.ProductCard
import com.example.barcodeapp.ui.theme.BarcodeAppTheme
import com.example.barcodeapp.utils.products
import com.journeyapps.barcodescanner.ScanOptions

@Composable
fun HomeScreen(innerPadding: PaddingValues){
    val context = LocalContext.current
    var barcode by remember {
        mutableStateOf("")
    }
    var productName by remember {
        mutableStateOf("")
    }
    val cartProducts = remember {
        mutableStateListOf<Product>()
    }
    val scanLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ){result ->
        val content = result.data?.getStringExtra("SCAN_RESULT")
        Log.i("BarcodeValue", content.toString())
        barcode = content.toString()
        val product = products.firstOrNull{ it.barcode == content }
        if(product != null){
            // productName = product.name
            cartProducts.add(product)
        }
    }

    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "La tienda de Juan")
        Button(onClick = {
            // LANZAR ACTIVITY DE LA CAMARA. (ESPERAR UN RESULTADO)
            val intent = ScanOptions()
            intent.setPrompt("Escanea algo cuki")
            intent.setBeepEnabled(true)
            intent.setOrientationLocked(true)
            scanLauncher.launch(intent.createScanIntent(context))
        }) {
            Text(text = "Escanear")
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ){
            items(cartProducts){
                ProductCard(it)
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview(){
    BarcodeAppTheme {
        HomeScreen(innerPadding = PaddingValues(0.dp))
    }
}