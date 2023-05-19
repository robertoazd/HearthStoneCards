package com.robertoazeredo.hearthstonecardsgit.di

import com.robertoazeredo.hearthstonecardsgit.data.repository.CardsRepository
import com.robertoazeredo.hearthstonecardsgit.data.repository.CardsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCardsRepository(cardsRepository: CardsRepositoryImpl): CardsRepository
}