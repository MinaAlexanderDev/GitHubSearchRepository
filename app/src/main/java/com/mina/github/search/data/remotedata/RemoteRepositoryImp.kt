package com.mina.github.search.data.remotedata

import com.mina.github.search.api.ServiceAPI
import com.mina.github.search.models.repository.RepositoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RemoteRepositoryImp @Inject constructor(private val api: ServiceAPI) : RemoteRepository {

    override suspend fun getRepository(
        query: String,
        page: Int,
        perPage: Int
    ): Response<RepositoryModel> = withContext(Dispatchers.IO) {
        api.getAPIRepositoriesJson(query, page, perPage)
    }


}