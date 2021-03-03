package com.alessandro.scryfallapi.network

import com.alessandro.scryfallapi.network.model.CardDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IScryfallApiService {
    @GET("/cards/named")
    suspend fun searchCardByName(
        @Query("fuzzy")
        fuzzy: String
    ): Response<CardDto>
}