package com.origin.book.booksharing

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TitleRepository: Repository {
    private var disposable: Disposable? = null
    private val apiService by lazy {
        ApiService.create()
    }

    fun fetchTitles(): MutableLiveData<TitleList> {
        val data = MutableLiveData<TitleList>()
        disposable = apiService.fetchTitles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> data.value = result}
                )
        return data
    }

    fun searchBook(title: String, onSuccess: (BookTitle) -> Unit, onFail: (Throwable) -> Unit) {
        disposable = apiService.searchBook(title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> onSuccess(result)},
                        { error -> onFail(error)}
                )
    }
}