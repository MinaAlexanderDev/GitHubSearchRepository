package com.mina.github.search.data.localdata.jsondata

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mina.github.search.ItemApplication
import com.mina.github.search.models.repository.RepositoryModel
import java.io.IOException


class JsonExtract {

    fun getJsonDataFromAsset(fileName: String): RepositoryModel? {
        var jsonString = ""
        val gson = Gson()
        val listPersonType = object : TypeToken<RepositoryModel>() {}.type
        return try {
            jsonString = ItemApplication.context?.assets?.open(fileName)
                ?.bufferedReader()
                .use { it?.readText().toString() }

            gson.fromJson(jsonString, listPersonType)

        } catch (ioException: IOException) {
            ioException.printStackTrace()
            gson.fromJson(jsonString, listPersonType)
        }
    }
}