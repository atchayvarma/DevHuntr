package tech.tamilanapps.devhuntr.network.repo

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import retrofit2.Response
import tech.tamilanapps.devhuntr.database.dao.HistoryDao
import tech.tamilanapps.devhuntr.database.entity.HistoryEntity
import tech.tamilanapps.devhuntr.network.api.DocsApi
import tech.tamilanapps.devhuntr.network.models.Docs
import tech.tamilanapps.devhuntr.network.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DocsRepo @Inject constructor(
    var docsApi: DocsApi,
    var historyDao:HistoryDao
) {

    suspend fun getDocSearchResults(query:String):Flow<Resource<Docs>> = flow {

        while (true) {
            //Setting the resource to state of loading
            emit(Resource.Loading())

            //Fetching the search results
            val searchResults = docsApi.getDocs(
                query = query,
                doc_id = "androidDocs"
            )

            //Emitting the search results
            emit(handleResponse(searchResults))

            break
        }
    }.flowOn(Dispatchers.IO).onEach{ res ->
        historyDao.insertHistory(
            HistoryEntity(
            title = query,
                doc = "Android"
        )
        )
    }


    /** Handling the Response */
    private fun handleResponse(response: Response<Docs>): Resource<Docs> {

        if (response.isSuccessful){
            response.body()?.let { searchResponse ->
                return Resource.Success(searchResponse)
            }
        }

        //Returning error if response is not successful
        return Resource.Error(null,response.message())

    }
}