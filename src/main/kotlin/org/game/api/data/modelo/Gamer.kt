package org.game.api.data.modelo

import org.game.api.extensao.transformarEmIdade
import java.util.*
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                gerarIdentificador()
            }
        }
    var idInterno: String? = null
        private set
    val jogos = mutableListOf<Jogo?>()

    constructor(nome: String, email: String, dataNascimento: String, usuario: String) :
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        gerarIdentificador()
    }

    init {
        this.validaNome()
        this.validaEmail()
    }

    private fun gerarIdentificador() {
        val sequencial = Random.nextInt(10000)
        val tag = String.format("%04d", sequencial)

        this.idInterno = "$usuario#$tag"
    }

    private fun validaEmail() {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        check(regex.matches(email)) { "Email informado inválido :(" }
    }

    private fun validaNome() {
        check(nome.isNotBlank() && nome.isNotEmpty()) { "Nome informado inválido :(" }
    }

    fun alugar(jogo: Jogo): Aluguel {
        return Aluguel(this, jogo)
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno, jogos=$jogos)"
    }

    companion object {
        fun criar(leitura: Scanner): Gamer {
            println("Bem vindo! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("S", true)) {
                println("Digite seu data nascimento (dd/mm/aaaa):")
                val dataNascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                val gamer = Gamer(nome, email, dataNascimento, usuario)

                val transformarEmIdade = runCatching {
                    val idade = gamer.dataNascimento?.transformarEmIdade()
                    println("Você tem $idade anos")
                }

                transformarEmIdade.onFailure {
                    println("Você deve preencher a data de nascimento no seguinte padrão -> dd/mm/aaaa")
                }





                return gamer
            }

            return Gamer(nome, email)
        }
    }


}
