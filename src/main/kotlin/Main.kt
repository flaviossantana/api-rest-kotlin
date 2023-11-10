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

    val jogo = Jogo()
    jogo.titulo = "The Witcher 3: Wild Hunt"
    jogo.capa = "https://steamcdn-a.akamaihd.net/steam/apps/292030/header.jpg?t=1605812508"
    jogo.descricao = "The Witcher 3: Wild Hunt é um RPG de mundo aberto, ambientado em um mundo fantástico cheio de escolhas importantes e consequências de impacto. Em The Witcher, você joga como o caçador de monstros profissional Geralt da Rívia, que está em busca da criança da profecia em um vasto mundo aberto, rico em cidades mercantis, ilhas com piratas vikings, passagens perigosas nas montanhas e cavernas esquecidas a serem exploradas."

    println(jogo)

}
