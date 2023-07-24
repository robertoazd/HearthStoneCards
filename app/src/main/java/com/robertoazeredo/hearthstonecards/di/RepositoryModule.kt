package com.robertoazeredo.hearthstonecards.di

import com.robertoazeredo.hearthstonecards.data.repository.CardsRepository
import com.robertoazeredo.hearthstonecards.data.repository.CardsRepositoryImpl
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