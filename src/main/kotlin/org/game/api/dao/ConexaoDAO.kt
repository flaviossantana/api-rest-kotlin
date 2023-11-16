package org.game.api.dao

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object ConexaoDAO {

    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("apigames")
        return factory.createEntityManager()
    }

    fun conectar(): Connection? {
        return try {
            Class.forName("org.mariadb.jdbc.Driver")
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/apigames?user=root")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

}
