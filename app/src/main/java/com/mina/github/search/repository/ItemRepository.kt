package com.mina.github.search.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.mina.github.search.pagingsource.PagingSourceItems
import javax.inject.Inject


class ItemRepository @Inject constructor(private val api: RepositoryImp) {


    fun getSearchDataResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 30,
                enablePlaceholders = false

            ),
            pagingSourceFactory = { PagingSourceItems(api, query) }

        ).liveData


}