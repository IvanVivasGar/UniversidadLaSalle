package com.example.lasalleapp.models

data class Student (
    val name: String,
    val birthdate: String,
    val email: String,
    val photo: String,
    val career: Career,
    val currentSemester: Int,
    val payments: List<Payment> = emptyList()
){
    val grade: Double
        get() {
            val coursedSubjects = career.subjects.filter { it.coursed } // Filter coursed subjects
            val totalSubjects = coursedSubjects.size
            if (totalSubjects == 0) {
                return 0.0
            }
            val sumOfGrades = coursedSubjects.sumOf { it.finalGrade } // Sum grades of coursed subjects
            val average = sumOfGrades / totalSubjects
            return String.format("%.1f", average).toDouble()
        }
}