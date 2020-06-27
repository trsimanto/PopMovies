package com.towhid.popmusic.activity.ac_movie_details.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chaadride.network.api.RetrofitClient
import com.towhid.popmusic.network.model.movie_details.response.MovieDetailsRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsActivityViewModel : ViewModel() {

    var resultLiveData: MutableLiveData<Any>? = null
    fun callDetailsList(movieId: Long): MutableLiveData<Any> {
        if (resultLiveData == null) {
            resultLiveData = MutableLiveData()
        }
        val call: Call<MovieDetailsRes> = RetrofitClient.getInstance().getApi().MovieDetailsRes_(
            movieId,
            "4752cd17517d23913284ff7c2a02c981"

        )

        call.enqueue(object : Callback<MovieDetailsRes> {
            override fun onResponse(call: Call<MovieDetailsRes>, response: Response<MovieDetailsRes>) {
                resultLiveData!!.postValue(null)
                if (response.isSuccessful) {
                    resultLiveData!!.value = response.body()

                }

            }

            override fun onFailure(call: Call<MovieDetailsRes>, t: Throwable) {
                resultLiveData!!.postValue(null)
                resultLiveData!!.value = t
            }
        })



        return resultLiveData as MutableLiveData<Any>
    }

}