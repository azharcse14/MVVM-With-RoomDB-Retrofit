package com.azhar.mvvmwithroomretrofit.view.di

import android.app.Application
import com.azhar.mvvmwithroomretrofit.model.api.QuoteService
import com.azhar.mvvmwithroomretrofit.model.api.RetrofitHelper
import com.azhar.mvvmwithroomretrofit.model.db.QuoteDatabase
import com.azhar.mvvmwithroomretrofit.model.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}