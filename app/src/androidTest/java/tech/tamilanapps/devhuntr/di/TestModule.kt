package tech.tamilanapps.devhuntr.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.tamilanapps.devhuntr.database.db.FrameWorkDatabase
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestModule {


    @Provides
    @Singleton
    @Named("test_db")
    fun provideFrameworkDatabase(
        @ApplicationContext
        ctx: Context
    ) = Room.inMemoryDatabaseBuilder(
        ctx,
        FrameWorkDatabase::class.java
    ).build()
}