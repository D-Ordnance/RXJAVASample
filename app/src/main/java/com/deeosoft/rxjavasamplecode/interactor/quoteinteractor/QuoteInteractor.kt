package com.deeosoft.rxjavasamplecode.interactor.quoteinteractor

import com.deeosoft.rxjavasamplecode.Interactor.QuoteInteractor.IQuoteInteractor
import com.deeosoft.rxjavasamplecode.domain.entities.Quote
import com.deeosoft.rxjavasamplecode.repositories.quoterepository.IQuoteRepository
import io.reactivex.Observable

class QuoteInteractor(private val iQuoteRepository: IQuoteRepository): IQuoteInteractor {

    override fun insert(quote: Quote){
        iQuoteRepository.insert(quote)
    }

    override fun update(quote: Quote){
        iQuoteRepository.update(quote)
    }

    override fun delete(quote: Quote){
        iQuoteRepository.delete(quote)
    }

    override fun deleteAllQuotes(){
        iQuoteRepository.deleteAllQuotes()
    }

    override fun getAllQuotes(): Observable<List<Quote>> {
        return iQuoteRepository.getAllQuotes()
    }
}