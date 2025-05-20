package com.example.myapplication

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FlugoalScreen(
    totalIngresos: Double,
    totalEgresos: Double,
    saldoActual: Double,
    movimientosRecientes: List<String>
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo animado en el layer más bajo
        AnimatedBackground()

        // Contenido encima del fondo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Resumen Financiero",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1A237E),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        "Total Ingresos: $${String.format("%.2f", totalIngresos)}",
                        color = Color(0xFF2E7D32),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        "Total Egresos: $${String.format("%.2f", totalEgresos)}",
                        color = Color(0xFFC62828),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        "Saldo Actual: $${String.format("%.2f", saldoActual)}",
                        color = Color(0xFF0D47A1),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Movimientos Recientes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A237E),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(movimientosRecientes.size) { index ->
                    MovimientoTextoItem(texto = movimientosRecientes[index])
                }
            }
        }
    }
}

@Composable
fun MovimientoTextoItem(texto: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFBBDEFB)),
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Text(
            text = texto,
            modifier = Modifier.padding(16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF0D47A1)
        )
    }
}

@Composable
fun AnimatedBackground() {
    val infiniteTransition = rememberInfiniteTransition()
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 800f,
        animationSpec = infiniteRepeatable(tween(30000, easing = LinearEasing))
    )
    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 600f,
        animationSpec = infiniteRepeatable(tween(20000, easing = LinearEasing))
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            color = Color(0xFFBBDEFB).copy(alpha = 0.15f),
            radius = 250f,
            center = Offset(offsetX % size.width, offsetY % size.height)
        )
        drawCircle(
            color = Color(0xFF64B5F6).copy(alpha = 0.1f),
            radius = 180f,
            center = Offset((offsetX * 1.3f) % size.width, (offsetY * 1.2f) % size.height)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFlugoalScreen() {
    FlugoalScreen(
        totalIngresos = 1240.50,
        totalEgresos = 780.75,
        saldoActual = 459.75,
        movimientosRecientes = listOf(
            "Ingreso: Salario",
            "Egreso: Renta",
            "Ingreso: Venta producto"
        )
    )
}
