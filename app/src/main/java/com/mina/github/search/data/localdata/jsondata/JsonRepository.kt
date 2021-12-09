package com.mina.github.search.data.localdata.jsondata

import com.mina.github.search.models.repository.RepositoryModel


interface JsonRepository {
    suspend fun getJsonDataFromAsset(fileName: String): RepositoryModel?
}