package com.mina.github.search.pagingsource

import androidx.paging.PagingSource
import com.mina.github.search.ItemApplication
import com.mina.github.search.models.repository.Items
import com.mina.github.search.repository.RepositoryImp
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class PagingSourceItems(private val api: RepositoryImp, private val query: String) :
    PagingSource<Int, Items>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {

        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return try {

            val response = api.getAPIRepositoriesJson(query, position, params.loadSize)
            val responseData = mutableListOf<Items>()
            val data = response.body()?.items
            data?.let { responseData.addAll((data)) }
            if (data != null) {
                responseData.addAll((data))

            }
            LoadResult.Page(
                data = responseData,
                prevKey = null,
                nextKey = if (data?.isEmpty() == true) null else position + 1
            )

        } catch (exception: IOException) {
            val listOfData =
                ItemApplication.context?.let { api.getJsonDataFromAsset("mockdata.json") }
            val responseData = mutableListOf<Items>()

            if (listOfData != null) {
                val data = listOfData.items
                responseData.addAll((data))
                LoadResult.Page(
                    data = responseData,
                    prevKey = null,
                    nextKey = if (data.isEmpty()) null else position + 1
                )
            } else {
                LoadResult.Error(exception)
            }

        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }

    }
}