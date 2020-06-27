package com.towhid.popmusic.network.model.trailer.response
class MovieTrailerRes(
    private var id: Long,
    private var results: List<Result>
) {

    fun getId(): Long {
        try {
            return id
        } catch (e: NullPointerException) {
            return 0
        }

    }

    fun getPayload(): List<Result> {
        return results
    }


}