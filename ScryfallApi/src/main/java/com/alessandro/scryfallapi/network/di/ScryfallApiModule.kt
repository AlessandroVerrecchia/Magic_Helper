package com.alessandro.scryfallapi.network.di

import com.alessandro.scryfallapi.network.IScryfallApiService
import com.alessandro.scryfallapi.network.retrofit.RetrofitBuilder
import com.alessandro.scryfallapi.network.useCase.GetCardByNameUseCase
import com.alessandro.scryfallapi.network.useCase.IGetCardByNameUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val ScryFallApiModule: Module = module {
    single {
        RetrofitBuilder(
            baseUrl = "https://api.scryfall.com/"
        ).build()
            .create(IScryfallApiService::class.java)
    }

    factory<IGetCardByNameUseCase> {
        GetCardByNameUseCase(
            scryfallService = get()
        )
    }
}