package tech.tamilanapps.devhuntr.database.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tech.tamilanapps.devhuntr.database.dao.HistoryDao
import tech.tamilanapps.devhuntr.database.entity.HistoryEntity
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    var historyDao: HistoryDao
) : ViewModel(){

    val histories:MutableState<List<HistoryEntity>> = mutableStateOf(listOf())

    fun getAllHistories() = viewModelScope.launch {
        val historiesQuery = historyDao.getAllHistory()
        histories.value = historiesQuery
    }


}