package com.hosein.nzd.kotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val apiService : ApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://hosein-nzd.ir/android_app/student/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(ApiService::class.java)
        }

        lifecycleScope.launchWhenCreated {
            val students : List<Student> = apiService.getStudent()
            println(students[0])
        }*/

        //coroutine with mvvm

        val mainViewModel = MainViewModel()

        /*mainViewModel.studentLiveData.observe(this , Observer {
            println(it[4])
        })*/

        mainViewModel.error.observe(this , Observer {
            println("error -> $it")
        })

        mainViewModel.studentLivedataScope.observe(this , Observer {
            println(it[4])
        })

    }
}