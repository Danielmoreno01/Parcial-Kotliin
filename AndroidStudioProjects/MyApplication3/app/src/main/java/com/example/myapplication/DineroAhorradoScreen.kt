package com.example.myapplication

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Movimiento

@Composable
fun DineroAhorradoScreen(movimientos: List<Movimiento>) {
    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedBackgroundDineroAhorrado()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Dinero Ahorrado",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF00796B),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(movimientos.size) { index ->
                    MovimientoCardDineroAhorrado(movimiento = movimientos[index])
                }
            }
        }
    }
}

@Composable
fun MovimientoCardDineroAhorrado(movimiento: Movimiento) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB2DFDB)),
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = movimiento.tipo,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF004D40)
            )
            Text(
                text = "Monto: $${movimiento.monto}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                text = "Fecha: ${movimiento.fecha}",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
            movimiento.descripcion?.takeIf { it.isNotBlank() }?.let {
                Text(
                    text = "Descripción: $it",
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color(0xFF00796B)
                )
            }
        }
    }
}

@Composable
fun AnimatedBackgroundDineroAhorrado() {
    val infiniteTransition = rememberInfiniteTransition()
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 900f,
        animationSpec = infiniteRepeatable(tween(28000, easing = LinearEasing))
    )
    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 650f,
        animationSpec = infiniteRepeatable(tween(20000, easing = LinearEasing))
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            color = Color(0xFF004D40).copy(alpha = 0.15f),
            radius = 260f,
            center = Offset(offsetX % size.width, offsetY % size.height)
        )
        drawCircle(
            color = Color(0xFF00796B).copy(alpha = 0.1f),
            radius = 190f,
            center = Offset((offsetX * 1.5f) % size.width, (offsetY * 1.4f) % size.height)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDineroAhorrado() {
    DineroAhorradoScreen(movimientos = emptyList())
}
