package org.game.api.dao

import jakarta.persistence.EntityManager

abstract class APIGamesDAO<TDTO, TEntity>(
    protected val entityManager: EntityManager,
    val type: Class<TEntity>) {

    abstract fun toEntity(dto: TDTO): TEntity
    abstract fun toDTO(entity: TEntity): TDTO

    open fun excluir(id: Int){
        val query = entityManager
            .createQuery("FROM ${type.simpleName} WHERE id = :id ", type)
            .setParameter("id", id)

        val tEntity = query.singleResult

        entityManager.transaction.begin()
        entityManager.remove(tEntity)
        entityManager.transaction.commit()
    }

    open fun buscarPorId(id: Int): TDTO{
        val query = entityManager.createQuery("FROM ${type.simpleName} WHERE id = :id ", type)
            .setParameter("id", id)
        return toDTO(query.singleResult)
    }

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
