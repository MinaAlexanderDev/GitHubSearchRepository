package com.mina.github.search.repository

import com.mina.github.search.data.localdata.jsondata.JsonRepository
import com.mina.github.search.models.repository.RepositoryModel
import com.mina.github.search.data.remotedata.RemoteRepository
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val jsonRepository: JsonRepository,
) : Repository {

    override suspend fun getAPIRepositoriesJson(
        word: String,
        page: Int,
        perPage: Int
    ) = remoteRepository.getRepository(word, page, perPage)

    override suspend fun getJsonDataFromAsset(fileName: String): RepositoryModel? {
        return jsonRepository.getJsonDataFromAsset(fileName)
    }

}