package org.game.api.client

import com.google.gson.Gson
import org.game.api.data.api.JogoSharkAPI
import org.game.api.data.modelo.Jogo
import org.game.api.extensao.toJogo

class GameClient {

    fun buscaJogo(idBusca: String): Jogo {

        val path = "https://www.cheapshark.com/api/1.0/games?id=$idBusca"
        val body = HttpClientAPI.enviar(path)

       val jogoAPI = Gson().fromJson(body, JogoSharkAPI::class.java)
        return jogoAPI.toJogo()

    }

}
