package com.alessandro.scryfallapi.network.useCase

import com.alessandro.scryfallapi.network.model.CardDto
import com.alessandro.scryfallapi.network.utils.Result

interface IGetCardByNameUseCase {
    suspend fun execute(query: String): Result<CardDto>
}