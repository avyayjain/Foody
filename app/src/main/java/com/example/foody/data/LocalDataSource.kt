package com.example.foody.data

import com.example.foody.data.database.RecipesDao
import com.example.foody.data.database.entities.FavoritesEntity
import com.example.foody.data.database.entities.FoodJokeEntity
import com.example.foody.data.database.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
){
    fun readRecipes():Flow<List<RecipesEntity>>{
        return recipesDao.readRecipes()
    }

    fun readFavouriteRecipes():Flow<List<FavoritesEntity>>{
        return recipesDao.readFavouriteRecipes()
    }

    fun readFoodJoke(): Flow<List<FoodJokeEntity>>{
        return recipesDao.readFoodJoke()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity){
        recipesDao.insertRecipes(recipesEntity)
    }

    suspend fun insertFavoriteRecipes(favoritesEntity: FavoritesEntity){
        recipesDao.insertFavouriteRecipe(favoritesEntity)
    }

    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity){
        recipesDao.insertFoodJoke(foodJokeEntity)
    }

    suspend fun deleteFavouriteRecipe(favoritesEntity: FavoritesEntity){
        recipesDao.deleteFavoriteRecipe(favoritesEntity)
    }

    suspend fun deleteAllFavoritesRecipe(){
        recipesDao.deleteAllFavoriteRecipes()
    }

}