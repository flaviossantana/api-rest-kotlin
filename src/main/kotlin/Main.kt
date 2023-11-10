import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

fun main() {

    val httpClient: HttpClient = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()

    val response = httpClient.send(request, BodyHandlers.ofString())

    val json = response.body()

    println(json)

    val theWitcher = Jogo(
        "The Witcher 3: Wild Hunt",
        "https://steamcdn-a.akamaihd.net/steam/apps/292030/header.jpg?t=1605812508")

    theWitcher.descricao = "The Witcher 3: Wild Hunt é um RPG de mundo aberto."

    println(theWitcher)

    val legoBatman = Jogo(
        capa = "https://steamcdn-a.akamaihd.net/steam/apps/292030/header.jpg?t=1605812508",
        titulo = "LEGO Batman")

    legoBatman.descricao = "The Witcher 3: Wild Hunt é um RPG de mundo aberto."

    println(legoBatman)

    val gson = Gson().fromJson(json, Informacao::class.java)

    println(gson)


}
