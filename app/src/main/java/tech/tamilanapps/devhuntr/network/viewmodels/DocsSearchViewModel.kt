package tech.tamilanapps.devhuntr.network.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import tech.tamilanapps.devhuntr.network.models.DocsItem
import tech.tamilanapps.devhuntr.network.repo.DocsRepo
import tech.tamilanapps.devhuntr.network.util.Resource
import javax.inject.Inject

@HiltViewModel
class DocsSearchViewModel @Inject constructor(
    var docsRepo: DocsRepo
): ViewModel() {


    val docsResults = mutableStateOf<ArrayList<DocsItem>>(arrayListOf())
    val isLoading = mutableStateOf(true)
    val errorMessage = mutableStateOf("")


    fun searchForDocs(query:String) = viewModelScope.launch {

        val response = docsRepo.getDocSearchResults(query = query)

        response.collect { res ->

            when(res){
                is Resource.Success -> {
                    docsResults.value = res.data!!
                    isLoading.value = false
                }

                is Resource.Error -> {
                    isLoading.value = false
                    errorMessage.value = res.message!!
                }

                is Resource.Loading -> {
                    isLoading.value = true
                }
            }


        }



    }

}