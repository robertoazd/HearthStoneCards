package com.robertoazeredo.hearthstonecards.data.repository

import com.robertoazeredo.hearthstonecards.data.api.ResultApi
import com.robertoazeredo.hearthstonecards.data.model.CardResponse

interface CardsRepository {
    suspend fun getCards(): ResultApi<List<CardResponse>>
}