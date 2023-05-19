package com.robertoazeredo.hearthstonecardsgit.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertoazeredo.hearthstonecardsgit.data.api.ResultApi
import com.robertoazeredo.hearthstonecardsgit.data.model.CardResponse
import com.robertoazeredo.hearthstonecardsgit.data.repository.CardsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val cardsRepository: CardsRepository
) : ViewModel() {

    private val _cards = MutableLiveData<List<CardResponse>?>()
    val cards: LiveData<List<CardResponse>?> = _cards

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getCards() {
        viewModelScope.launch {
            when (val resultApi = cardsRepository.getCards()) {
                is ResultApi.Success -> {
                    _cards.value = resultApi.value
                }
                is ResultApi.Error -> {
                    _error.value = resultApi.message
                }
            }
        }
    }
}