package com.deeosoft.rxjavasamplecode.repositories.quoterepository

import android.util.Log
import com.deeosoft.rxjavasamplecode.domain.entities.Quote
import com.deeosoft.rxjavasamplecode.repositories.doas.QuoteDao
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QuoteRepository(private val quoteDao: QuoteDao): IQuoteRepository {

    override fun insert(quote: Quote) {
        quoteDao.insert(quote)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("RXJAVA", "insert successful")},
                { Log.d("RXJAVA", "insert error")}
            )
    }

    override fun update(quote: Quote) {
        quoteDao.update(quote)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {Log.d("RXJAVA", "update successful")},
                {Log.d("RXJAVA", "update error")}
            )
    }

    override fun delete(quote: Quote) {
        quoteDao.delete(quote)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {Log.d("RXJAVA", "delete successful")},
                {Log.d("RXJAVA", "delete error")}
            )
    }

    override fun deleteAllQuotes() {
        Completable.fromAction{quoteDao.deleteAllQuotes()}
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {Log.d("RXJAVA", "Delete all successful")},
                {Log.d("RXJAVA", "Delete all error")}
            )
    }

    override fun getAllQuotes(): Observable<List<Quote>> = quoteDao.getAllQuotes()
}