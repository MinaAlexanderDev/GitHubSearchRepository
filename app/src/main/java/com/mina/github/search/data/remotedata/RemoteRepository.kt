package com.mina.github.search.data.remotedata

import com.mina.github.search.models.repository.RepositoryModel
import retrofit2.Response

interface RemoteRepository {

    suspend fun getRepository(
        query: String, page: Int,
        perPage: Int
    ): Response<RepositoryModel>

}