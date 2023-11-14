package org.game.api.client

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.game.api.data.api.GamerInfoAPI
import org.game.api.data.modelo.Gamer
import org.game.api.extensao.toGamer

class GamerClient {

    fun buscaGamer(): List<Gamer> {

        val path = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val body = HttpClientAPI.enviar(path)

        val tipoGameInfro = object : TypeToken<List<GamerInfoAPI>>() {}.type
        val infoGamers: List<GamerInfoAPI> = Gson().fromJson(body, tipoGameInfro)

        return infoGamers.map { infoGamer ->
            infoGamer.toGamer()
        }
    }

}
