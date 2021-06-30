package com.deeosoft.rxjavasamplecode.repositories.doas

import androidx.room.*
import com.deeosoft.rxjavasamplecode.domain.entities.Quote
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface QuoteDao {

    @Insert
    fun insert(quote: Quote): Completable

    @Update
    fun update(quote: Quote): Completable

    @Delete
    fun delete(quote: Quote): Completable

    @Query("DELETE FROM quotes_table")
    fun deleteAllQuotes()

    @Query("SELECT * FROM quotes_table ORDER BY id DESC")
    fun getAllQuotes(): Observable<List<Quote>>
}