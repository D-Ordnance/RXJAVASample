package com.deeosoft.rxjavasamplecode.presenters.quotepresenter

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deeosoft.rxjavasamplecode.Interactor.QuoteInteractor.IQuoteInteractor
import com.deeosoft.rxjavasamplecode.domain.entities.Quote
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QuotePresenter(private val iQuoteInteractor: IQuoteInteractor): IQuotePresenter {

    private var allQuotes: MutableLiveData<List<Quote>> = MutableLiveData()

    init {
        loadQuotes()
    }

    override fun insert(quote: Quote){
        iQuoteInteractor.insert(quote)
    }

    override fun update(quote: Quote) {
        iQuoteInteractor.update(quote)
    }

    override fun delete(quote: Quote) {
        iQuoteInteractor.delete(quote)
    }

    override fun deleteAllQuotes() {
        iQuoteInteractor.deleteAllQuotes()
    }

    override fun getAllQuotes(): LiveData<List<Quote>> {
        return allQuotes
    }

    @SuppressLint("CheckResult")
    override fun loadQuotes() {
        iQuoteInteractor.getAllQuotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {quote -> allQuotes.postValue(quote)},
                {error -> Log.d("RXJAVA", "Error getting info from interactor into presenter $error")}
            )
    }
}