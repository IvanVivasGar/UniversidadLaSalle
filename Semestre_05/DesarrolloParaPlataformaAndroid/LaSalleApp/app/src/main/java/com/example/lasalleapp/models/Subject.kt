package com.example.lasalleapp.models

data class Subject (
    val id: Int,
    val name: String,
    val coursed: Boolean = false,
    val firstCut: Double,
    val secondCut: Double,
    val thirdCut: Double
){
    val finalGrade: Double
        get() {
            val calculatedGrade = (firstCut * 0.2) + (secondCut * 0.2) + (thirdCut * 0.6)
            return String.format("%.1f", calculatedGrade).toDouble()
        }
}