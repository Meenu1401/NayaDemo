package com.example.viewdata
import com.example.entity.ServerResonse
import com.example.entity.TrendingRespositry
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class Presenter @Inject constructor(val viewData: ViewData) {


    fun showLoading() {
        viewData.showLoading()
    }

    fun resetToDefault() {
        viewData.defaultState()
    }


    fun subscribeDataResponse(responsObservable: Observable<ServerResonse<ArrayList<TrendingRespositry>>>): Disposable {
        return responsObservable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response -> handleDataResponse(response)
            }
    }

    private fun handleDataResponse(result: ServerResonse<ArrayList<TrendingRespositry>>) {
        if (result.success) {
            viewData.showSuccess()
            viewData.setParsedData(result.data!!)
        } else {
            viewData.showNetworkFailure()
        }
    }
}