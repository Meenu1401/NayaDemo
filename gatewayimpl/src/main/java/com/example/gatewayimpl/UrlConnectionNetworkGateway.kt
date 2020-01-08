package com.example.gatewayimpl

import com.example.entity.ServerResonse
import com.example.entity.TrendingRespositry
import com.example.gateway.NetworkGateway
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UrlConnectionNetworkGateway : NetworkGateway {

    override fun loadUrl(url: String): Observable<ServerResonse<ArrayList<TrendingRespositry>>> {
        return Observable.create {
            val service = getRetrofitInstance(url).create(Api::class.java)
            val call = service.result

            call.enqueue(object : Callback<ArrayList<TrendingRespositry>> {
                override fun onFailure(call: Call<ArrayList<TrendingRespositry>>?, t: Throwable?) {
                    it.onNext(ServerResonse(false, null, null, 0))
                }

                override fun onResponse(
                    call: Call<ArrayList<TrendingRespositry>>?,
                    response: Response<ArrayList<TrendingRespositry>>?
                ) {
                    it.onNext(ServerResonse(true, response?.body(), null, 0))
                }
            })
        }
    }


    private fun getRetrofitInstance(url: String): Retrofit {

        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }

}



