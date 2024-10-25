package com.example.fakestoreapp.models

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
){
    val computedTitle get() = if(title.length > 11) "${title.substring(0, 11)}..." else title
    val computedPrice get() = "$$price"
}