package com.example.lasalleapp.models

data class Payment (
    val id: Int,
    val period: String,
    val dueDate: String,
    val paid: Boolean,
)