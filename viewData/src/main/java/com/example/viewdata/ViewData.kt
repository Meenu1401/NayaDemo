package com.example.viewdata

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.entity.TrendingRespositry
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class ViewData @Inject constructor() {

    private val showingProgress = BehaviorSubject.create<ArrayList<TrendingRespositry>>()
    val message = ObservableField<String>()
    val showProgress = ObservableBoolean()
    var trendingList = ArrayList<TrendingRespositry>()


    fun defaultState() {
        showProgress.set(false)
        message.set("")
    }


    fun showLoading() {
        showProgress.set(true)
        message.set("")

    }

    fun showSuccess() {
        showProgress.set(false)
        message.set("Data loaded")
    }


    fun showNetworkFailure() {
        showProgress.set(false)
        message.set("Network Error")
    }

    fun showConnectionError() {
        showProgress.set(false)
        message.set("Connection Not Available")

    }


    fun setParsedData(trendingList: ArrayList<TrendingRespositry>) {
        this.trendingList = trendingList
        updateProgressStatus(trendingList)

    }

    fun observeProgressStatus(): Observable<ArrayList<TrendingRespositry>> {
        return showingProgress
    }

    fun updateProgressStatus(showing: ArrayList<TrendingRespositry>) {
        showingProgress.onNext(showing)
    }

}


