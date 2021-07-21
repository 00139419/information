package com.morales.daniel.myapplication12th.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "term_table")
data class Term (
    @PrimaryKey var word: String,
    var description: String
)