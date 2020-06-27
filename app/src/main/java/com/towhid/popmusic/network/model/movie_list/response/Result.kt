package com.towhid.popmusic.network.model.movie_list.response

class Result(
    private var id: Long,
    private var poster_path: String

    ) {
    fun getPoster_path(): String {
        if (poster_path.equals(null))
            return ""
        return poster_path
    }
    fun getId(): Long {
        return try {
            id
        } catch (e: Exception) {
            0
        }
    }

}
