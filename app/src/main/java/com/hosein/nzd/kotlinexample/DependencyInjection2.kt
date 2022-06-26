package com.hosein.nzd.kotlinexample

import android.util.Log

interface RequestService{
    fun sendRequest(url: String)
}

object InjectorHttp{
    fun inject():RequestService{
        return Volley()
    }
}

class Retrofit:RequestService {
    override fun sendRequest(url: String) {
        Log.i("Retrofit", "sendRequest -> $ $url")
    }
}
class Volley:RequestService{
    override fun sendRequest(url: String) {
        Log.i("Volley", "sendRequest -> $ $url")
    }
}