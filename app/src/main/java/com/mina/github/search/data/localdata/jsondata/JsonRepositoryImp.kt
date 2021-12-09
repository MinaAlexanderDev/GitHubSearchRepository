package com.mina.github.search.data.localdata.jsondata

import com.mina.github.search.models.repository.RepositoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class JsonRepositoryImp @Inject constructor(private val jsonExtract: JsonExtract) :
    JsonRepository {
    override suspend fun getJsonDataFromAsset(fileName: String): RepositoryModel? =

        withContext(Dispatchers.IO) {
            jsonExtract.getJsonDataFromAsset(fileName)

        }


}