package com.example.gateway

import com.example.entity.ServerResonse
import com.example.entity.TrendingRespositry
import io.reactivex.Observable


interface NetworkGateway {
    fun loadUrl(url : String) : Observable<ServerResonse<ArrayList<TrendingRespositry>>>

}