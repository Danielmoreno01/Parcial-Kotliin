package com.example.myapplication.ui.theme

data class Movimiento(
    val id: Long? = null,
    val tipo: String,
    val monto: Double,
    val fecha: String,
    val descripcion: String? = null,
    val usuarioId: Long? = null,
    val metaId: Long? = null
)
