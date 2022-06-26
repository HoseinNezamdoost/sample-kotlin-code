package com.hosein.nzd.kotlinexample

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {

    //launch is coroutine builder
    val job : Job = GlobalScope.launch(Dispatchers.IO + CoroutineName("manager")) {
        val posts = requestPosts()
        addInDatabase(posts, )
        updateUi(posts)
    }

    // this method is coroutine builder
    runBlocking (Dispatchers.IO + CoroutineName("manager2")){
        //join is for close this method (main method)
        job.join()
    }
    //cancel request (task) with job
    //job.cancel()

    //-----------------------------------------------------------------------------

    //async programming in coroutine
    val job2 : Job = GlobalScope.launch (Dispatchers.IO){
        //async is coroutine builder
        val posts = async { requestPosts() }
        val comments = async { requestComments() }
        //await() is for get value (T) from returner method async (Deferred(T))
        addInDatabase(posts.await(), comments.await())
        //switch dispatcher with function withContext
        withContext(Dispatchers.Main){
            updateUi(posts.await())
        }

    }

    runBlocking { job2.join() }
}

//===================================

suspend fun requestPosts(): List<Posts> {
    println("requestPosts(), current name -> ${Thread.currentThread().name}")
    delay(1500)
    return posts
}
suspend fun requestComments(): List<Comments>{
    println("requestComments(), current name -> ${Thread.currentThread().name}")
    delay(3000)
    return comments
}

suspend fun addInDatabase(posts: List<Posts> , comments: List<Comments>) {
    println("addInDatabase(), current name -> ${Thread.currentThread().name}")
    delay(800)
}
suspend fun addInDatabase(posts: List<Posts>) {
    println("addInDatabase(), current name -> ${Thread.currentThread().name}")
    delay(800)
}

fun updateUi(posts: List<Posts>) {
    println("updateUi(), current name -> ${Thread.currentThread().name}")
}

//data classes
data class Posts(var title: String) {}
data class Comments(var title: String) {}

val posts = listOf<Posts>(Posts("reza"), Posts("hosein"), Posts("mamad"))
val comments = listOf<Comments>(Comments("thanks"), Comments("veryGood"), Comments("nice"))