package org.game.api.dao

import org.game.api.data.modelo.Jogo

class JogoDAO {

    fun salvar(jogo: Jogo) {

        val conexao = ConexaoDAO.conectar()
        val query = "INSERT INTO jogos (capa, descricao, preco, titulo) VALUES(?, ?, ?, ?);"

        if (conexao != null) {
            try {
                val insert = conexao.prepareStatement(query)

                insert.setString(1, jogo.capa)
                insert.setString(2, jogo.descricao)
                insert.setDouble(3, jogo.preco)
                insert.setString(4, jogo.titulo)

                insert.executeUpdate()
                insert.close()
            } finally {
                conexao.close()
            }
        }

    }

    fun todosH(): List<Jogo>{
        val em = ConexaoDAO.getEntityManager();
        try {

            val query = em.createQuery("FROM JOGO", Jogo::class.java)
            return query.resultList

        }finally {
            em.close()
        }
    }

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
