package com.origin.book.booksharing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleListViewModel: ViewModel() {
    private val _bookTitles = MutableLiveData<List<BookTitle>>()

    val bookTitles: LiveData<List<BookTitle>>
        get() = _bookTitles

}