package com.origin.book.booksharing

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("books")
    fun fetchTitles(): Observable<TitleList>

    @GET("books")
    fun searchBook(@Query("title") title: String): Observable<BookTitle>

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://private-96a91-booksapi22.apiary-mock.com/")
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}

