fun main() {
    val reservas = mutableListOf<Hotel_UMD>()

    while (true) {
        println("\n--------HOTEL UMD-------")
        println("\n       Bienvenid@")
        println("   1. Crear reserva")
        println("   2. Cancelar reserva")
        println("   3. Mostrar todas las reservas")
        println("   4. Salir")
        when (readIntInput("")) {
            1 -> {
                val numeroHabitacion = readIntInput("Número de habitación: ")
                if (reservas.any { it.getNumeroHabitacion() == numeroHabitacion }) {
                    println("Error: La habitación $numeroHabitacion ya está reservada.")
                } else {
                    val reserva = Hotel_UMD()
                    val idReserva = readIntInput("ID de reserva: ")
                    val idHuesped = readIntInput("ID de huésped: ")
                    print("Nombre del huésped: ")
                    val nombreHuesped = readln()
                    print("Email del huésped: ")
                    val emailHuesped = readln()
                    print("Tipo de habitación: ")
                    val tipoHabitacion = readln()
                    val precioPorNoche = readDoubleInput("Precio por noche: ")
                    val nochesReservadas = readIntInput("Cantidad de noches reservadas: ")
                    val totalPagar = calcularMontoTotal(precioPorNoche, nochesReservadas)
                    println("El monto total a pagar es: \$${totalPagar}")
                    reserva.setReserva(idReserva, idHuesped, nombreHuesped, emailHuesped, numeroHabitacion, tipoHabitacion, precioPorNoche, nochesReservadas)
                    reservas.add(reserva)
                    println("Reserva realizada con éxito.")
                }
            }
            2 -> {
                val idReserva = readIntInput("Ingrese el ID de la reserva a cancelar: ")
                reservas.removeIf { it.getIdReserva() == idReserva }
                println("Reserva con ID $idReserva ha sido cancelada.")
            }
            3 -> {
                if (reservas.isEmpty()) {
                    println("No hay reservas activas.")
                } else {
                    reservas.forEach {
                        println("ID Reserva: ${it.getIdReserva()}, Huésped: ${it.getNombreHuesped()}, Monto: \$${it.montoTotal()}")
                    }
                }
            }
            4 -> return
            else -> println("Opción no válida.")
        }
    }
}
