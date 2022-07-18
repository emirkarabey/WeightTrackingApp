package com.example.weighttrackingapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "weight")
data class WeightEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "timestamp") val timestamp: Date?,
    @ColumnInfo(name = "value") val value: Float?
)