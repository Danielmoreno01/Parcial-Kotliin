fun main() {
    val mascotas = mutableListOf<ClaseMascota>()
    val consultas = mutableListOf<ConsultaMedica>()

    while (true) {
        println("\n=== MENÚ PRINCIPAL ===")
        println("1. Registrar nueva mascota")
        println("2. Listar mascotas registradas")
        println("3. Registrar consulta médica")
        println("4. Mostrar costos de consultas")
        println("5. Salir")
        print("Seleccione una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Nombre de la mascota: ")
                val nombre = readLine().orEmpty()

                print("Especie: ")
                val especie = readLine().orEmpty()

                print("Edad: ")
                val edad = readLine()?.toIntOrNull() ?: 0

                print("Peso: ")
                val peso = readLine()?.toDoubleOrNull() ?: 0.0

                val mascota = ClaseMascota(nombre, especie, edad, peso)
                mascotas.add(mascota)
                println("Mascota registrada con éxito.")
            }

            2 -> {
                if (mascotas.isEmpty()) {
                    println("No hay mascotas registradas.")
                } else {
                    println("\n=== Lista de Mascotas Registradas ===")
                    mascotas.forEachIndexed { index, mascota ->
                        println("${index + 1}. ${mascota.describirMascota()}")
                    }
                }
            }

            3 -> {
                if (mascotas.isEmpty()) {
                    println("No hay mascotas registradas. Registre una primero.")
                    continue
                }

                println("\nSeleccione la mascota para la consulta:")
                mascotas.forEachIndexed { index, mascota ->
                    println("${index + 1}. ${mascota.nombre}")
                }

                print("Ingrese el número de la mascota: ")
                val indexMascota = readLine()?.toIntOrNull()?.minus(1)

                if (indexMascota == null || indexMascota !in mascotas.indices) {
                    println("Selección inválida.")
                    continue
                }

                print("Diagnóstico médico: ")
                val diagnostico = readLine().orEmpty()

                print("Costo de la consulta: ")
                val costo = readLine()?.toDoubleOrNull() ?: 0.0

                print("¿Incluye medicación? (si/no): ")
                val incluyeMed = readLine().orEmpty().lowercase() == "si"

                val consulta = ConsultaMedica(mascotas[indexMascota], diagnostico, costo, incluyeMed)
                consultas.add(consulta)
                println("Consulta médica registrada con éxito.")
            }

            4 -> {
                if (consultas.isEmpty()) {
                    println("No hay consultas registradas.")
                } else {
                    println("\n=== Costos de Consultas Médicas ===")
                    consultas.forEach {
                        println("Mascota: ${it.mascota.nombre}, Diagnóstico: ${it.diagnosticoMedico}, Costo total: ${it.calcularCosto()}")
                    }
                }
            }

            5 -> {
                println("Saliendo del programa...")
                return
            }

            else -> println("Opción no válida, intente de nuevo.")
        }
    }
}
