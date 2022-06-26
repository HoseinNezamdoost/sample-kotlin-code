package com.hosein.nzd.kotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DependencyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dependency)

        val retrofit = InjectorHttp.inject()
        retrofit.sendRequest("https://hosein-nzd.ir/")

    }
}