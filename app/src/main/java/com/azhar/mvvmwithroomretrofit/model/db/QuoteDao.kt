package com.azhar.mvvmwithroomretrofit.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.azhar.mvvmwithroomretrofit.model.data.Result

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes() : List<Result>
}