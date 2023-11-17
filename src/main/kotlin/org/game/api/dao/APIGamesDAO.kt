package org.game.api.dao

abstract class APIGamesDAO<TModel> {

    abstract fun todos(): List<TModel>
    abstract fun salvar(objeto: TModel)

}
