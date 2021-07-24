package tech.tamilanapps.devhuntr.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import tech.tamilanapps.devhuntr.database.entity.FrameWorkEntity
import tech.tamilanapps.devhuntr.database.entity.HistoryEntity

@Dao
interface FrameWorkDao {

    @Query("SELECT * FROM `framework-table`")
    suspend fun getFramework() : FrameWorkEntity

    @Insert
    suspend fun insertFramework(frameWorkEntity: FrameWorkEntity)
}