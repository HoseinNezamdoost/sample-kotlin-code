package com.hosein.nzd.kotlinexample

fun main() {
    val a = 10
    val b = 7

    //if sonaty
    if (a > b)
        println("a > b")

    //if expiration
    val result = if (a < b) "a smaller than b" else "b smaller than a"
    println(result)

    //when (switch in java)
    when (a) {
        10 -> {
            println("a = 10")
            println("a = 10")
        }
        7 -> println("a = 7")
        //between 6 , 10
        in 6..10 -> println("a between 6 , 10")
        !in 6..10 -> println("!a between 6 , 10")
        //instance of
        is Int -> println("a instance of integer")
        7, 8, 9, 10 -> println("true")
        else -> println("else")
    }

    //when expiration
    val resultForWhen = when (b) {
        10 -> "b = 10"
        resulted() -> "a = resulted"
        else -> "else"
    }

    println(resultForWhen)

}

fun resulted(): Int = 7
