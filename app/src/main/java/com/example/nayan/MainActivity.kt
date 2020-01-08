package com.example.nayan

import android.os.Bundle
import com.example.controller.ControllerFactory
import com.example.controller.Controller
import com.example.entity.UrlRequest
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    lateinit var viewHolder: ViewHolder

    private lateinit var controller: Controller

    @Inject
    lateinit var controllerFactory: ControllerFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initController()
        initView()
    }

    private fun initController() {
        val urlRequest = UrlRequest("https://github-trending-api.now.sh/", "id")
        controller = controllerFactory.create(urlRequest)
        controller.setup()
    }

    private fun initView() {
        viewHolder = ViewHolder(this)
        viewHolder.bind(controller)
        setContentView(viewHolder.rootView())
    }
}
