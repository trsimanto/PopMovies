package com.towhid.popmusic.activity.ac_movie_list.model

class Movielist(
    private var moviePosterLink1: String,
    private var movieId1: Long,
    private var moviePosterLink2: String,
    private var movieId2: Long

) {

    fun getMoviePosterLink1(): String {
        if (moviePosterLink1.equals(null))
            return ""
        return "https://image.tmdb.org/t/p/w600_and_h900_bestv2"+moviePosterLink1
    }
    fun getMovieId1(): Long {

        return movieId1
    }
    fun getMoviePosterLink2(): String {
        if (moviePosterLink2.equals(null))
            return ""
        return "https://image.tmdb.org/t/p/w600_and_h900_bestv2"+moviePosterLink2
    }
    fun getMovieId2(): Long {

        return movieId2
    }
}