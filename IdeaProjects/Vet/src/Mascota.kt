open class ClaseMascota(
    var nombre: String,
    var especie: String,
    var edad: Int,
    var peso: Double
) {
    fun actualizarPeso(nuevoPeso: Double) {
        peso = nuevoPeso
    }

    fun incrementarEdad() {
        edad++
    }

    fun describirMascota(): String {
        return "Mascota: $nombre, Especie: $especie, Edad: $edad años, Peso: $peso kg"
    }
}