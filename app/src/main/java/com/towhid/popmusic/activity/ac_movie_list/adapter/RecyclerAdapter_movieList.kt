package com.towhid.popmusic.activity.ac_movie_list.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.chaadride.Toast.ToastShow
import com.squareup.picasso.Picasso
import com.towhid.popmusic.R
import com.towhid.popmusic.activity.ac_movie_details.view.MovieDetailsActivity
import com.towhid.popmusic.activity.ac_movie_list.model.Movielist
import kotlinx.android.synthetic.main.item_movie.view.*


class RecyclerAdapter_movieList(var mcontext: Context, var mData: MutableList<Movielist>) :
    RecyclerView.Adapter<RecyclerAdapter_movieList.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        view = LayoutInflater.from(mcontext).inflate(R.layout.item_movie, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        Picasso.get().load(mData[position].getMoviePosterLink1()).into(holder.movie_l)
        Picasso.get().load(mData[position].getMoviePosterLink2()).into(holder.movie_2)
        holder.movie_l.setOnClickListener {
           mcontext.startActivity(Intent(mcontext, MovieDetailsActivity::class.java).putExtra("movieId",mData[position].getMovieId1()))
        }
        holder.movie_2.setOnClickListener {
           mcontext.startActivity(Intent(mcontext, MovieDetailsActivity::class.java).putExtra("movieId",mData[position].getMovieId2()))
        }


    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movie_l: ImageView
        val movie_2: ImageView

        init {
            movie_l = itemView.limg
            movie_2 = itemView.rimg
        }
    }
    init {
        this.mData = mData
    }
}