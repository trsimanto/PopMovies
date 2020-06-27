package com.towhid.popmusic.activity.ac_movie_details.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chaadride.network.api.RetrofitClient
import com.towhid.popmusic.network.model.movie_details.response.MovieDetailsRes
import com.towhid.popmusic.network.model.trailer.response.MovieTrailerRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsActivityViewModel_trailer : ViewModel() {

    var resultLiveData: MutableLiveData<Any>? = null
    fun callTrailerList(movieId: Long): MutableLiveData<Any> {
        if (resultLiveData == null) {
            resultLiveData = MutableLiveData()
        }
        val call: Call<MovieTrailerRes> = RetrofitClient.getInstance().getApi().MovieTrailerRes_(
            movieId,
            "4752cd17517d23913284ff7c2a02c981"

        )

        call.enqueue(object : Callback<MovieTrailerRes> {
            override fun onResponse(call: Call<MovieTrailerRes>, response: Response<MovieTrailerRes>) {
                resultLiveData!!.postValue(null)
                if (response.isSuccessful) {
                    resultLiveData!!.value = response.body()

                }

            }

            override fun onFailure(call: Call<MovieTrailerRes>, t: Throwable) {
                resultLiveData!!.postValue(null)
                resultLiveData!!.value = t
            }
        })



        return resultLiveData as MutableLiveData<Any>
    }

}