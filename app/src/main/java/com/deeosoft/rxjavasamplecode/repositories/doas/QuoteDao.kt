package com.deeosoft.rxjavasamplecode.repositories.doas

import androidx.room.Dao
import androidx.room.Insert
import com.deeosoft.rxjavasamplecode.domain.entities.Quote
import io.reactivex.Completable

@Dao
interface QuoteDao {

    @Insert
    fun insert(quote: Quote) : Completable
}