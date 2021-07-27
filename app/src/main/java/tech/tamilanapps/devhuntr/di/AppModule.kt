package tech.tamilanapps.devhuntr.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.tamilanapps.devhuntr.database.db.FrameWorkDatabase
import tech.tamilanapps.devhuntr.database.db.HistoryDatabase
import tech.tamilanapps.devhuntr.network.api.DocsApi
import tech.tamilanapps.devhuntr.others.BASE_URL
import tech.tamilanapps.devhuntr.others.FRAMEWORK_DB_NAME
import tech.tamilanapps.devhuntr.others.HISTORY_DB_NAME
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /** Database layer dependencies */

    @Provides
    @Singleton
    fun provideHistoryDatabaseBuilder(
        @ApplicationContext
        appCtx:Context
    ):HistoryDatabase = Room.databaseBuilder(
        appCtx,
        HistoryDatabase::class.java,
        HISTORY_DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideHistoryDao(historyDatabaseBuilder: HistoryDatabase) = historyDatabaseBuilder.historyDao()

    @Provides
    @Singleton
    fun provideFrameWorkDatabase(
        @ApplicationContext
        appCtx:Context
    ):FrameWorkDatabase = Room.databaseBuilder(
        appCtx,
        FrameWorkDatabase::class.java,
        FRAMEWORK_DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideFrameworkDao(frameWorkDatabase: FrameWorkDatabase) = frameWorkDatabase.frameworkDao()



    /** Network layer dependencies */

    @Provides
    @Singleton
    fun providesOKHttpClient() = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideDocsApi(retrofit: Retrofit) = retrofit
        .create(DocsApi::class.java)

}