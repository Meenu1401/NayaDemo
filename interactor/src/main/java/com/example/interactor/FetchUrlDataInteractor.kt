package com.example.interactor

import com.example.entity.ServerResonse
import com.example.entity.TrendingRespositry
import com.example.entity.UrlRequest
import com.example.gateway.ConnectionGateway
import com.example.gateway.NetworkGateway
import com.example.gateway.scopes.AppScope
import io.reactivex.Observable
import javax.inject.Inject

@AppScope
class FetchUrlDataInteractor @Inject constructor(
    private val networkGateway: NetworkGateway,
    private val connectionGateway: ConnectionGateway
) {

    fun execute(url: UrlRequest): Observable<ServerResonse<ArrayList<TrendingRespositry>>> {
        if (!connectionGateway.isConnected()) {
            return Observable.create { ServerResonse(false, null, null, 0) }
        }

        return networkGateway.loadUrl(url.url)
            .map { result ->
                result
            }
    }

}