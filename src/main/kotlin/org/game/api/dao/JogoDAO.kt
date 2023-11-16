package org.game.api.dao

import org.game.api.data.entidade.JogoEntity
import org.game.api.data.modelo.Jogo
import org.game.api.extensao.toJogo

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

    fun todos(): List<Jogo> {
        val em = ConexaoDAO.getEntityManager();
        try {

            val query = em.createQuery("FROM JogoEntity", JogoEntity::class.java)
            return query.resultList.map { jogoEntity -> jogoEntity.toJogo() }
        } finally {
            em.close()
        }
    }
}
