package com.towhid.popmusic.network.model.movie_list.response

import java.lang.NullPointerException
class MovieListRes(
private var page: Int,
private var total_pages: Int,
private var results: List<Result>
) {

    fun getPage(): Int {
        try {
            return page
        } catch (e: NullPointerException) {
            return 0
        }

    }
    fun getTotal_pages(): Int {
        try {
            return total_pages
        } catch (e: NullPointerException) {
            return 0
        }

    }
    fun getPayload(): List<Result> {
        return results
    }


}