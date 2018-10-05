package com.origin.book.booksharing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val repository = TitleRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository.fetchTitles()

        searchBar.setOnSearchListener(object: FloatingSearchView.OnSearchListener    {
            override fun onSearchAction(currentQuery: String?) {
                helloWorld.text = currentQuery
                Log.d("test", "")
            }

            override fun onSuggestionClicked(searchSuggestion: SearchSuggestion?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
