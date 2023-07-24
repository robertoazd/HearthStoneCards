package com.robertoazeredo.hearthstonecards.data.api

import com.robertoazeredo.hearthstonecards.data.model.CardResponse
import retrofit2.Response
import retrofit2.http.GET

interface CardSetApi {
    @GET("cards/sets/classic?attack=4&localee=ptBR")
    suspend fun getCards(): Response<List<CardResponse>>
}