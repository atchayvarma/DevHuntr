package tech.tamilanapps.devhuntr.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import tech.tamilanapps.devhuntr.database.dao.FrameWorkDao
import tech.tamilanapps.devhuntr.database.dao.HistoryDao
import tech.tamilanapps.devhuntr.database.entity.FrameWorkEntity
import tech.tamilanapps.devhuntr.database.entity.HistoryEntity
import javax.inject.Singleton



@Database(entities = [FrameWorkEntity::class], version = 1)
abstract class FrameWorkDatabase : RoomDatabase() {

    abstract fun frameworkDao(): FrameWorkDao
}