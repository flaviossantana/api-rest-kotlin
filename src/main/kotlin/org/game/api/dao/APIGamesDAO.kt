package org.game.api.dao

import jakarta.persistence.EntityManager

abstract class APIGamesDAO<TDTO, TEntity>(
    protected val entityManager: EntityManager,
    val type: Class<TEntity>) {

    abstract fun toEntity(dto: TDTO): TEntity
    abstract fun toDTO(entity: TEntity): TDTO

    open fun todos(): List<TDTO> {
        val query = entityManager.createQuery("FROM ${type.simpleName}", type)
        return query.resultList.map { entity: TEntity -> toDTO(entity) }
    }

    open fun salvar(dto: TDTO) {
        entityManager.transaction.begin()
        entityManager.persist(toEntity(dto))
        entityManager.transaction.commit()
    }

}
