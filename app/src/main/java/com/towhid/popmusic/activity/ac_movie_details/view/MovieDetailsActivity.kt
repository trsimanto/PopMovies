package com.towhid.popmusic.activity.ac_movie_details.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.towhid.popmusic.R
import com.towhid.popmusic.activity.ac_movie_details.adapter.RecyclerAdapter_trailerList
import com.towhid.popmusic.activity.ac_movie_details.model.Trailerlist
import com.towhid.popmusic.activity.ac_movie_details.viewModel.MovieDetailsActivityViewModel
import com.towhid.popmusic.activity.ac_movie_details.viewModel.MovieDetailsActivityViewModel_trailer
import com.towhid.popmusic.network.model.movie_details.response.MovieDetailsRes
import com.towhid.popmusic.network.model.trailer.response.MovieTrailerRes
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.toolber_lay.*

class MovieDetailsActivity : AppCompatActivity() {

    var movieDetailsActivityViewModel: MovieDetailsActivityViewModel? = null
    var movieDetailsActivityViewModel_trailer: MovieDetailsActivityViewModel_trailer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        var movieId = intent.getLongExtra("movieId", 500)
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true);
        movieDetailsActivityViewModel =
            ViewModelProvider(this)[MovieDetailsActivityViewModel::class.java]
        movieDetailsActivityViewModel_trailer =
            ViewModelProvider(this)[MovieDetailsActivityViewModel_trailer::class.java]

        movieDetailsActivityViewModel!!.callDetailsList(movieId).observe(
            this, Observer<Any> { any ->
                if (any is MovieDetailsRes) {
                    Picasso.get().load(any.getPoster_path()).into(movie_img)
                    overview.text = any.getOverview()
                    release_date.text = any.getRelease_date()
                    runtime.text = any.getRuntime()
                    movie_title.text = any.getTitle()
                    vote_average.text = any.getVote_average()
                } else if (any is Throwable) {

                }

            })
        movieDetailsActivityViewModel_trailer!!.callTrailerList(movieId).observe(
            this, Observer<Any> { any ->
                if (any is MovieTrailerRes) {
                    var recyclerAdapter_trailerList: RecyclerAdapter_trailerList
                    var rec_trailerList = mutableListOf<Trailerlist>()
                    recyclerAdapter_trailerList =
                        RecyclerAdapter_trailerList(this, rec_trailerList)
                    rec_trailer.layoutManager = LinearLayoutManager(this)
                    rec_trailer.adapter = recyclerAdapter_trailerList
                    for (n in any.getPayload().indices) {
                        rec_trailerList.add(
                            Trailerlist(
                                any.getPayload()[n].getKey(),
                                any.getPayload()[n].getName()
                            )
                        )
                    }
                    recyclerAdapter_trailerList.notifyDataSetChanged()

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
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
