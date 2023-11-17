package org.game.api.dao

import jakarta.persistence.EntityManager

abstract class APIGamesDAO<TModel>(protected val entityManager: EntityManager) {

    abstract fun toEntity(objeto: TModel)
    abstract fun todos(): List<TModel>

    open fun salvar(objeto: TModel){
        entityManager.transaction.begin()
        entityManager.persist(toEntity(objeto))
        entityManager.transaction.commit()
    }

}
