package com.mina.github.search.api

import com.mina.github.search.models.repository.RepositoryModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("/search/repositories")
    suspend fun getAPIRepositoriesJson(
        @Query("q") word: String, @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<RepositoryModel>
}