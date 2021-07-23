package tech.tamilanapps.devhuntr.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import tech.tamilanapps.devhuntr.others.HISTORY_TABLE_NAME

@Entity(tableName = HISTORY_TABLE_NAME)
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "key")
    val historyKey:Int = 0,
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name ="doc") val doc:String
)
