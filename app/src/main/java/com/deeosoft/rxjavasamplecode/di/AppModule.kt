package com.deeosoft.rxjavasamplecode.di

import androidx.room.Room
import com.deeosoft.rxjavasamplecode.Interactor.QuoteInteractor.IQuoteInteractor
import com.deeosoft.rxjavasamplecode.interactor.quoteinteractor.QuoteInteractor
import com.deeosoft.rxjavasamplecode.presenters.quotepresenter.QuotePresenter
import com.deeosoft.rxjavasamplecode.repositories.databases.AppDatabase
import com.deeosoft.rxjavasamplecode.repositories.quoterepository.IQuoteRepository
import com.deeosoft.rxjavasamplecode.repositories.quoterepository.QuoteRepository
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module{
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "quote_database").build()}

    single{get<AppDatabase>().quoteDao()}

    single<IQuoteRepository>{QuoteRepository(get())}

    single<IQuoteInteractor> { QuoteInteractor(get()) }

    viewModel { QuotePresenter(get()) }
}