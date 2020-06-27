package com.towhid.popmusic.network.model.trailer.response

class Result(
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
