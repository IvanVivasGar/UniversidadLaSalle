package com.example.barcodeapp.models

data class Product(
    val barcode: String,
    val name: String,
    val price: Double,
    val image: String
)