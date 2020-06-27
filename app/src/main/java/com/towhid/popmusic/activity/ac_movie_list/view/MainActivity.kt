package com.towhid.popmusic.activity.ac_movie_list.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.towhid.popmusic.R
import com.towhid.popmusic.activity.ac_movie_list.adapter.RecyclerAdapter_movieList
import com.towhid.popmusic.activity.ac_movie_list.model.Movielist
import com.towhid.popmusic.activity.ac_movie_list.viewModel.MainActivityViewModel
import com.towhid.popmusic.network.model.movie_list.response.MovieListRes
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolber_lay.*


class MainActivity : AppCompatActivity() {
    var rec_movieList = mutableListOf<Movielist>()
    var recyclerAdapter_movieList: RecyclerAdapter_movieList =
        RecyclerAdapter_movieList(this, rec_movieList)
    var pageNumber = 0
    var end=false
    var mainActivityViewModel: MainActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        rec_movie.layoutManager = LinearLayoutManager(this)
        rec_movie.adapter = recyclerAdapter_movieList
        MovieShow(++pageNumber)




        rec_movie.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager =
                    LinearLayoutManager::class.java.cast(recyclerView.layoutManager)
                val totalItemCount = layoutManager!!.itemCount
                val lastVisible = layoutManager!!.findLastVisibleItemPosition()
                val endHasBeenReached = lastVisible + 5 >= totalItemCount
                if (totalItemCount > 0 && endHasBeenReached) {
                    MovieShow(++pageNumber)
                }
            }
        })


    }

    private fun MovieShow(page: Int) {
        if (end)
            return
        mainActivityViewModel!!.callMovieList(page).observe(
            this, Observer<Any> { any ->
                if (any is MovieListRes) {
                    if (any.getPage()==any.getTotal_pages())
                        end=true
                    for (n in 0..any.getPayload().size - 1 step 2) {
                        rec_movieList.add(
                            Movielist(
                                any.getPayload()[n].getPoster_path(),
                                any.getPayload()[n].getId(),
                                any.getPayload()[n + 1].getPoster_path(),
                                any.getPayload()[n + 1].getId()

                            )
                        )
                    }
                    recyclerAdapter_movieList.notifyDataSetChanged()

                } else if (any is Throwable) {

                }

            })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
