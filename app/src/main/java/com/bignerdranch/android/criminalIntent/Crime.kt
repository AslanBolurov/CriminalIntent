package com.bignerdranch.android.criminalIntent

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Crime(
    @PrimaryKey
    @ColumnInfo(name="id")
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name="title")
    var title: String = "",
    @ColumnInfo(name="date")
    var date: Date = Date(),
    @ColumnInfo(name="isSolved")
    var isSolved: Boolean = false,
    @ColumnInfo(name="suspect")
    var suspect: String = ""
) {

    val photoFileName
        get() = "IMG_$id.jpg"

}
