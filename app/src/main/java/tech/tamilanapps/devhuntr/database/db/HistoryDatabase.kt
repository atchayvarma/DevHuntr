package tech.tamilanapps.devhuntr.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import tech.tamilanapps.devhuntr.database.dao.HistoryDao
import tech.tamilanapps.devhuntr.database.entity.HistoryEntity
import javax.inject.Singleton



@Database(entities = [HistoryEntity::class], version = 1)
abstract class HistoryDatabase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao
}