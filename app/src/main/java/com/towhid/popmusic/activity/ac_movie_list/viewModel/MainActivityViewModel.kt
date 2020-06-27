package com.towhid.popmusic.activity.ac_movie_list.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chaadride.network.api.RetrofitClient
import com.towhid.popmusic.network.model.movie_list.response.MovieListRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var resultLiveData: MutableLiveData<Any>? = null
    fun callMovieList(page: Int): MutableLiveData<Any> {
        if (resultLiveData == null) {
            resultLiveData = MutableLiveData()
        }
        val call: Call<MovieListRes> = RetrofitClient.getInstance().getApi().MovieListRes_(
            "4752cd17517d23913284ff7c2a02c981",
            "en-US",
            page
        )

        call.enqueue(object : Callback<MovieListRes> {
            override fun onResponse(call: Call<MovieListRes>, response: Response<MovieListRes>) {
                resultLiveData!!.postValue(null)
                if (response.isSuccessful) {
                    resultLiveData!!.value = response.body()

                }

            }

            override fun onFailure(call: Call<MovieListRes>, t: Throwable) {
                resultLiveData!!.postValue(null)
                resultLiveData!!.value = t
            }
        })



        return resultLiveData as MutableLiveData<Any>
    }

}