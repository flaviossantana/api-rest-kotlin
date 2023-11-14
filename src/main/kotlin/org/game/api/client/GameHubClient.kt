package org.game.api.client

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.game.api.data.modelo.Jogo

class GameHubClient {

    fun buscaJogos(): List<Jogo> {

        val path = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val body = HttpClientAPI.enviar(path)

        val tipoJogo = object : TypeToken<List<Jogo>>() {}.type
        return Gson().fromJson(body, tipoJogo)
    }

}
