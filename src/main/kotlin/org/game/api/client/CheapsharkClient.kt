package org.game.api.client

import com.google.gson.Gson
import org.game.api.data.api.JogoSharkAPI

class CheapsharkClient {

    fun buscaJogo(idBusca: String): JogoSharkAPI {

        val path = "https://www.cheapshark.com/api/1.0/games?id=$idBusca"
        val body = HttpClientAPI.enviar(path)

        return Gson().fromJson(body, JogoSharkAPI::class.java)
    }

}
