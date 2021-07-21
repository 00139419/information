package com.morales.daniel.myapplication12th.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.morales.daniel.myapplication12th.data.dao.TermDao
import com.morales.daniel.myapplication12th.data.entity.Term

@Database(version = 1, entities = [Term::class])
abstract class DictionaryDataBase : RoomDatabase() {

    abstract fun termDao(): TermDao

companion object{
    @Volatile
    private var INSTANCE:DictionaryDataBase? = null

    fun getDataBase(Context: Context) = INSTANCE?: synchronized(this){
    val instance = Room.databaseBuilder(
        Context,
        DictionaryDataBase::class.java,
        "dictionary_db"
    ).build()

        INSTANCE = instance
        instance
    }
}

}