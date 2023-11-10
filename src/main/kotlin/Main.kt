import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)

    println("Digite um código de jogo para buscar na API: ")

    val idBusca = leitura.nextLine();
    val path = "https://www.cheapshark.com/api/1.0/games?id=$idBusca"

    val httpClient: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(path))
        .build()

    val response = httpClient.send(request, BodyHandlers.ofString())

    val json = response.body()

    val jogoSharkAPI = Gson().fromJson(json, JogoSharkAPI::class.java)

    println(jogoSharkAPI)

    val jogo = Jogo(jogoSharkAPI.info.title, jogoSharkAPI.info.thumb)

    println(jogo)

}
