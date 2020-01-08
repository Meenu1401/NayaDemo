package com.example.nayan

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.entity.TrendingRespositry
import kotlinx.android.synthetic.main.item_trending_list.view.*


class TrendingListAdapter(private val list: ArrayList<TrendingRespositry>) :
    RecyclerView.Adapter<TrendingListAdapter.TrendingListHolder>() {


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingListHolder {
        return TrendingListHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_trending_list, parent, false)
        )
    }


    override fun onBindViewHolder(holder: TrendingListHolder, position: Int) {
        holder.itemView.title.text = list[position].author
        holder.itemView.lang.text = list[position].language
    }


    inner class TrendingListHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        init {
            itemView.setOnClickListener {
                // Can write router to show detailed activity.

            }
        }
    }

}