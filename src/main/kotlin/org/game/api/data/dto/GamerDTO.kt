package org.game.api.data.dto

import org.game.api.data.contrato.Recomendavel
import org.game.api.extensao.transformarEmIdade
import java.time.LocalDate
import java.util.*
import kotlin.random.Random

data class GamerDTO(
    var nome: String,
    var email: String
) : Recomendavel {
    var id = 0
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
    var planoDTO: PlanoDTO = PlanoAvulsoDTO("BRONZE")
    val pesquisados = mutableListOf<JogoDTO?>()
    val recomendados = mutableListOf<JogoDTO>()
    val alugados = mutableListOf<AluguelDTO>()
    private val notas = mutableListOf<Int>()
    override val media: Double
        get() = notas.average()

    constructor(nome: String, email: String, dataNascimento: String?, usuario: String?) :
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        gerarIdentificador()
    }

    constructor(nome: String, email: String, dataNascimento: String?, usuario: String?, id: Int) :
            this(nome, email, dataNascimento, usuario) {
        this.id = id
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

    fun alugar(jogoDTO: JogoDTO, inicio: LocalDate, final: LocalDate): AluguelDTO {
        val alugel = AluguelDTO(this, jogoDTO, PeriodoDTO(inicio, final))
        this.alugados.add(alugel)
        return alugel
    }

    fun avaliar(jogoDTO: JogoDTO, nota: Int) {
        jogoDTO.recomendar(nota)
        recomendados.add(jogoDTO)
    }

    override fun recomendar(nota: Int) {
        notas.add(nota)
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', " +
                "email='$email', " +
                "dataNascimento=$dataNascimento, " +
                "usuario=$usuario, " +
                "idInterno=$idInterno, " +
                "jogos=$pesquisados," +
                "aligueis=$alugados)"
    }

    fun jogosDoMes(mesAluguel: Int): List<AluguelDTO> {
        return this.alugados
            .filter { it.periodo.inicio.monthValue == mesAluguel }
    }

    companion object {
        fun criar(leitura: Scanner): GamerDTO {
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

                val gamerDTO = GamerDTO(nome, email, dataNascimento, usuario)

                val transformarEmIdade = runCatching {
                    val idade = gamerDTO.dataNascimento?.transformarEmIdade()
                    println("Você tem $idade anos")
                }

                transformarEmIdade.onFailure {
                    println("Você deve preencher a data de nascimento no seguinte padrão -> dd/mm/aaaa")
                }





                return gamerDTO
            }

            return GamerDTO(nome, email)
        }
    }


}
