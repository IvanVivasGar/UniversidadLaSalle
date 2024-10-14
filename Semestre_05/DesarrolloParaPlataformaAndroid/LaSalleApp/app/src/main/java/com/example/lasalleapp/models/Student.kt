package com.example.lasalleapp.models

data class Student (
    val name: String,
    val birthdate: String,
    val email: String,
    val photo: String,
    val career: Career,
    val currentSemester: Int
){
    val grade: Double
        get() {
            val totalSubjects = career.subjects.size
            if (totalSubjects == 0) {
                return 0.0
            }
            val sumOfGrades = career.subjects.sumOf { it.finalGrade }
            val average = sumOfGrades / totalSubjects
            return String.format("%.1f", average).toDouble()
        }
}