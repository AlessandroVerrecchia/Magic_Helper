package com.alessandro.scryfallapi.network.useCase

import com.alessandro.scryfallapi.network.IScryfallApiService
import com.alessandro.scryfallapi.network.model.CardDto
import com.alessandro.scryfallapi.network.utils.Result
import com.alessandro.scryfallapi.network.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCardByNameUseCase(private val scryfallService: IScryfallApiService) :
    IGetCardByNameUseCase {
    override suspend fun execute(query: String): Result<CardDto> {
        return withContext(Dispatchers.IO) {
            try {
                Result(
                    Status.SUCCESS,
                    scryfallService.searchCardByName(query).body(),
                    null
                )
            } catch (exception: Exception) {
                Result(Status.ERROR, null, exception.message ?: "Error occured")
            }
        }
    }
}

