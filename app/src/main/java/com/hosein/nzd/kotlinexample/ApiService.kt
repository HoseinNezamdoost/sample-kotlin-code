package com.hosein.nzd.kotlinexample

import retrofit2.http.GET

interface ApiService {
    @GET("getStudent.php")
    suspend fun getStudent() : List<Student>
}