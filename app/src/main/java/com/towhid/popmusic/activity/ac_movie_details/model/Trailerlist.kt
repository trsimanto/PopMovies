package com.towhid.popmusic.activity.ac_movie_details.model

class Trailerlist(
    private var key: String,
    private var name: String

) {

    fun getKey(): String {
        if (key.equals(null))
            return ""
        return key
    }

    fun getName(): String {
        if (name.equals(null))
            return ""
        return name
    }

}