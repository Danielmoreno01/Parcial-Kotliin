class ConsultaMedica(
     val mascota: ClaseMascota,
     var diagnosticoMedico: String,
     var costoDeLaConsulta: Double,
     var incluyeMedicacion: Boolean
) {
     fun calcularCosto(): Double {
          return if (incluyeMedicacion) costoDeLaConsulta * 1.15 else costoDeLaConsulta
     }
}

