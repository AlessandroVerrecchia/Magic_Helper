package com.alessandro.magichelper.di

import com.alessandro.magichelper.scoreBoard.ScoreBoardViewModel
import com.alessandro.magichelper.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {

    viewModel {
        SearchViewModel(
            getCardByNameUseCase = get()
        )
    }

    viewModel {
        ScoreBoardViewModel()
    }

}