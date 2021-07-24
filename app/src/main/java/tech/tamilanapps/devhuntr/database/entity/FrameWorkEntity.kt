package tech.tamilanapps.devhuntr.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import tech.tamilanapps.devhuntr.others.FRAMEWORK_TABLE_NAME
import tech.tamilanapps.devhuntr.others.HISTORY_TABLE_NAME

@Entity(tableName = FRAMEWORK_TABLE_NAME)
data class FrameWorkEntity(
    @PrimaryKey(autoGenerate = true)
    val primaryKey: Int = 0,
    @ColumnInfo(name = "framework")
    val framework:String,
    @ColumnInfo(name = "endpoint")
    val frameworkEndpoint:String
)
