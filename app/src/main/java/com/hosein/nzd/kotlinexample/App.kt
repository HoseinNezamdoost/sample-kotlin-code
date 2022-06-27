package com.hosein.nzd.nikestore

import android.app.Application
import android.util.Log
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

interface HttpClient{
    fun requestService()
}

class Retrofit : HttpClient{
    override fun requestService() {
        Log.i("Retrofit", "requestService: ")
    }
}

interface LoadingImage{
    fun imageLoder()
}

class Picasso : LoadingImage{
    override fun imageLoder() {
        Log.i("Picasso", "imageLoder: ")
    }
}

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val myModule = module {
            //single for design pattern singleton but factory no like this

            factory <LoadingImage>{ Picasso() }
            single <HttpClient>{ Retrofit() }
            viewModel { MainViewModel(get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModule)
        }
    }
}