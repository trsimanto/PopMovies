package com.towhid.popmusic.activity.ac_movie_details.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.towhid.popmusic.R
import com.towhid.popmusic.activity.ac_movie_details.model.Trailerlist
import com.towhid.popmusic.activity.ac_youtube.view.YoutubeActivity
import kotlinx.android.synthetic.main.item_trailer.view.*


class RecyclerAdapter_trailerList(var mcontext: Context, var mData: MutableList<Trailerlist>) :
    RecyclerView.Adapter<RecyclerAdapter_trailerList.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        view = LayoutInflater.from(mcontext).inflate(R.layout.item_trailer, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.name.text=mData[position].getName()
         holder.play_lay.setOnClickListener {
           mcontext.startActivity(Intent(mcontext, YoutubeActivity::class.java).putExtra("youtube_key",mData[position].getKey()))
        }

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val play_lay: ConstraintLayout

        init {
            name = itemView.name
            play_lay = itemView.play_lay
        }
    }
    init {
        this.mData = mData
    }
}