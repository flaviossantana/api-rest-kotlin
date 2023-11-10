import com.google.gson.annotations.SerializedName

class Jogo(
    @SerializedName("title")
    private val titulo: String,
    @SerializedName("thumb")
    private val capa: String
) {

    var descricao = ""

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao='$descricao')"
    }

}
