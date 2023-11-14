package org.game.api.client

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.game.api.data.api.GameHubAPI
import org.game.api.data.modelo.Jogo
import org.game.api.extensao.toJogo

class GameHubClient {

    fun buscaJogos(): List<Jogo> {

        val path = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val body = HttpClientAPI.enviar(path)

        val tipoJogo = object : TypeToken<List<GameHubAPI>>() {}.type
        val gamesHub: List<GameHubAPI> = Gson().fromJson(body, tipoJogo)

        return gamesHub.map {
            game -> game.toJogo()
        }

    }

}
