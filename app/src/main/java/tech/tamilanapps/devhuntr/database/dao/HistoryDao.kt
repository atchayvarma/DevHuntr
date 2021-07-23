package tech.tamilanapps.devhuntr.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import tech.tamilanapps.devhuntr.database.entity.HistoryEntity


@Dao
interface HistoryDao {

    @Query("SELECT * FROM `history-table`")
    suspend fun getAllHistory() :List<HistoryEntity>

    @Insert
    suspend fun insertHistory(historyEntity: HistoryEntity)
}