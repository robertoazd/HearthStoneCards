package com.robertoazeredo.hearthstonecardsgit.data.repository

import com.robertoazeredo.hearthstonecardsgit.data.api.ResultApi
import com.robertoazeredo.hearthstonecardsgit.data.model.CardResponse

interface CardsRepository {
    suspend fun getCards(): ResultApi<List<CardResponse>>
}