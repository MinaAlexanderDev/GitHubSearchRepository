package com.mina.github.search.ui.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mina.github.search.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel @ViewModelInject constructor(
    private val repository: ItemRepository,
    @Assisted state: SavedStateHandle
) : ViewModel() {

    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)
    val searchRepo = currentQuery.switchMap { queryString ->
        repository.getSearchDataResults(queryString).cachedIn(viewModelScope)
    }

    fun searchQuery(query: String) {

        viewModelScope.launch {
            currentQuery.value = query
        }
    }

    companion object {
        private const val CURRENT_QUERY = "css"
        private const val DEFAULT_QUERY = "css"
    }
}