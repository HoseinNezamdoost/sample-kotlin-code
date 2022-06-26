package com.hosein.nzd.kotlinexample

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://hosein-nzd.ir/android_app/student/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

    var error = MutableLiveData<String>()
    private var exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        error.value = throwable.message
    }

    //livedata scope
    val studentLivedataScope: LiveData<List<Student>> = liveData(exceptionHandler) {
        val students = apiService.getStudent()
        emit(students)
    }

    //viewmodel scope
    var studentLiveData = MutableLiveData<List<Student>>()

    init {
        viewModelScope.launch(exceptionHandler) {
            studentLiveData.value = apiService.getStudent()
        }
    }

}