package com.morales.daniel.myapplication12th.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.morales.daniel.myapplication12th.data.entity.Term

@Dao
interface TermDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insert_or_replace(term:Term)

}