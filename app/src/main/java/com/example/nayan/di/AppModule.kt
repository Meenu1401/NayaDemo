package com.example.nayan.di

import android.content.Context
import com.example.gateway.ConnectionGateway
import com.example.gateway.NetworkGateway
import com.example.gateway.scopes.AppScope
import com.example.gatewayimpl.DummyConnectionGateway
import com.example.gatewayimpl.UrlConnectionNetworkGateway
import com.example.nayan.NayanApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {


    @AppScope
    @Provides
    fun networkGateway() : NetworkGateway {
        return UrlConnectionNetworkGateway()
    }

    @AppScope
    @Provides
    fun connetionGateway() : ConnectionGateway {
        return DummyConnectionGateway()
    }

    @Provides
    @AppScope
    fun context(app : NayanApplication) : Context {
        return app
    }

}
