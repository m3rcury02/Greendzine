package com.example.greendzine.data

data class Employees(
    val ID: Int,
    val Name: String,
    val DOB: String,
    val Role: String
)

data class EmpProd(
    val Day: String,
    val ProdPerc: Int
)
