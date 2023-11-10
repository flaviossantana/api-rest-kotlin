class Jogo(private val titulo: String, private val capa: String) {

    var descricao = ""

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao='$descricao')"
    }

}
