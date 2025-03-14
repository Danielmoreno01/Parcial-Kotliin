class Hotel_UMD {
    private var idReserva: Int = 0
    private var idHuesped: Int = 0
    private var nombreHuesped: String = ""
    private var emailHuesped: String = ""
    private var numeroHabitacion: Int = 0
    private var tipoHabitacion: String = ""
    private var precioPorNoche: Double = 0.0
    private var nochesReservadas: Int = 0

    fun setReserva(
        idReserva: Int,
        idHuesped: Int,
        nombreHuesped: String,
        emailHuesped: String,
        numeroHabitacion: Int,
        tipoHabitacion: String,
        precioPorNoche: Double,
        nochesReservadas: Int,
    ) {
        this.idReserva = idReserva
        this.idHuesped = idHuesped
        this.nombreHuesped = nombreHuesped
        this.emailHuesped = emailHuesped
        this.numeroHabitacion = numeroHabitacion
        this.tipoHabitacion = tipoHabitacion
        this.precioPorNoche = precioPorNoche
        this.nochesReservadas = nochesReservadas
    }

    fun getIdReserva() = idReserva
    fun getNumeroHabitacion() = numeroHabitacion
    fun getNombreHuesped() = nombreHuesped
    fun montoTotal(): Double {
        return precioPorNoche * nochesReservadas
    }
}

fun readIntInput(prompt: String): Int {
    while (true) {
        print(prompt)
        val input = readln()
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            println("Error: Ingresa un número válido.")
        }
    }
}

fun readDoubleInput(prompt: String): Double {
    while (true) {
        print(prompt)
        val input = readln()
        try {
            return input.toDouble()
        } catch (e: NumberFormatException) {
            println("Error: Ingresa un valor numérico válido.")
        }
    }
}

fun calcularMontoTotal(precioPorNoche: Double, nochesReservadas: Int): Double {
    return precioPorNoche * nochesReservadas
}