package org.game.api.dao

import org.game.api.data.modelo.Jogo

class JogoDAO {

    fun todos(): List<Jogo> {

        val jogos = mutableListOf<Jogo>()
        val conexao = ConexaoDAO.conectar()

        if (conexao != null) {
            try {
                val select = conexao.createStatement()
                val resultado = select.executeQuery("select * from jogos")


                while (resultado.next()) {
                    val id = resultado.getInt("id")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val titulo = resultado.getString("titulo")
                    val preco = resultado.getDouble("preco")

                    jogos.add(Jogo(titulo, capa, preco, descricao, id))
                }

                select.close()
            } finally {
                conexao.close()
            }
        }

        return jogos

    }

}
