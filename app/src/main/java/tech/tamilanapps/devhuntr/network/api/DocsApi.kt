package tech.tamilanapps.devhuntr.network.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import tech.tamilanapps.devhuntr.network.models.Docs

interface DocsApi {

    /** Leaving the parameter of GET empty as the endpoint is provided from @Url inside the function itself*/
    @GET()
    suspend fun getDocs(

        @Url
        doc_id:String,

        @Query("q")
        query:String

    ): Response<Docs>
}