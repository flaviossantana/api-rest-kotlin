package org.game.api.client

import com.google.gson.Gson
import org.game.api.data.api.GameSharkAPI
import org.game.api.data.dto.JogoDTO
import org.game.api.extensao.toJogo

class GameSharkClient {

    fun buscaJogo(idBusca: String): JogoDTO {

        val path = "https://www.cheapshark.com/api/1.0/games?id=$idBusca"
        val body = HttpClientAPI.enviar(path)

       val jogoAPI = Gson().fromJson(body, GameSharkAPI::class.java)
        return jogoAPI.toJogo()

    }

}
