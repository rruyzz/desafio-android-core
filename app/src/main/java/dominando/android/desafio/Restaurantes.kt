package dominando.android.desafio

import java.io.Serializable

class Restaurantes(val image: Int, val nome: String, val horario: String, val endereco: String):Serializable{
    override fun toString(): String {
        return "Restaurantes(image=$image, nome='$nome', horario='$horario', endereco='$endereco')"
    }
}