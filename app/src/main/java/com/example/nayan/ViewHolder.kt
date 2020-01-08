package com.example.nayan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.controller.Controller
import com.example.nayan.databinding.ActivityMainBinding

class ViewHolder(val context: Context) {

    private val binding: ActivityMainBinding =
        ActivityMainBinding.inflate(LayoutInflater.from(context))


    fun rootView(): View {
        return binding.root
    }

    fun bind(controller: Controller) {
        binding.viewHolder = this
        binding.data = controller.getViewData()
        binding.controller = controller
        controller.bindFetchUrlActionTo()
        controller.getViewData().observeProgressStatus().doOnNext {
            val trendingListAdapter = TrendingListAdapter(it)
            val layoutManagerHorizontal =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.layoutManager = layoutManagerHorizontal
            binding.recyclerView.adapter = trendingListAdapter
        }.subscribe()
    }
}