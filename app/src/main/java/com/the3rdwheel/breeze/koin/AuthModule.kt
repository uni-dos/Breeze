package com.the3rdwheel.breeze.koin

import com.the3rdwheel.breeze.network.AccessTokenAuthenticator
import com.the3rdwheel.breeze.network.AuthTokenInterceptor
import com.the3rdwheel.breeze.reddit.authentication.api.Auth
import com.the3rdwheel.breeze.network.ConnectivityInterceptor
import com.the3rdwheel.breeze.reddit.retrofit.RedditApi
import org.koin.android.ext.koin.androidContext

import org.koin.dsl.module

val authModules = module {

    single {
        ConnectivityInterceptor(
            androidContext()
        )
    }

    single { Auth.invoke(get()) }


    single { AccessTokenAuthenticator(get(), androidContext()) }
    single { AuthTokenInterceptor(androidContext()) }
    single { RedditApi.invoke(get(), get(), get()) }
}

