package com.robertoazeredo.hearthstonecards.data.repository

import com.robertoazeredo.hearthstonecards.data.api.CardSetApi
import com.robertoazeredo.hearthstonecards.data.api.ResultApi
import com.robertoazeredo.hearthstonecards.data.model.CardResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardsRepositoryImpl @Inject constructor(
    private val cardSetApi: CardSetApi
) : CardsRepository {

    override suspend fun getCards(): ResultApi<List<CardResponse>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = cardSetApi.getCards()
                val body = response.body()
                if (response.isSuccessful) {
                    if (body != null) {
                        ResultApi.Success(body)
                    } else {
                        ResultApi.Error("Error no data")
                    }
                } else {
                    ResultApi.Error("Generic error")
                }
            } catch (throwable: Throwable) {
                ResultApi.Error("Error unknown")
            }
        }
    }
}