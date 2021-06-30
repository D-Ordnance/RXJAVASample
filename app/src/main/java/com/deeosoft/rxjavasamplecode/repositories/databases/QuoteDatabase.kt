package com.deeosoft.rxjavasamplecode.repositories.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deeosoft.rxjavasamplecode.domain.entities.Quote
import com.deeosoft.rxjavasamplecode.repositories.doas.QuoteDao

@Database(entities = [Quote::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun quoteDao(): QuoteDao
}