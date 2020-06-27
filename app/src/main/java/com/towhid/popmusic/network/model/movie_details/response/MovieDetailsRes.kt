package com.towhid.popmusic.network.model.movie_details.response

class MovieDetailsRes(
    private var id: Long,
    private var overview: String,
    private var poster_path: String,
    private var release_date: String,
    private var runtime: Int,
    private var title: String,
    private var vote_average: Double
) {

    fun getId(): Long {
        try {
            return id
        } catch (e: NullPointerException) {
            return 0
        }

    }

    fun getRuntime(): String {
        return "${runtime}min"
    }

    fun getVote_average(): String {
        return "$vote_average/10"
    }

    fun getPoster_path(): String {
        if (poster_path.equals(null))
            return ""
        return "https://image.tmdb.org/t/p/w600_and_h900_bestv2" + poster_path
    }

    fun getOverview(): String {
        if (overview.equals(null))
            return ""
        return overview
    }

    fun getRelease_date(): String {
        if (release_date.equals(null))
            return ""
        return release_date.substring(0,4)
    }

    fun getTitle(): String {
        if (title.equals(null))
            return ""
        return title
    }

}