package com.hosein.nzd.kotlinexample

import org.json.JSONException
import org.json.JSONObject

fun main() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7)
    array.forEach {
        println(it)
    }

    val re = result(25, 25) { i, i2 ->
        i + i2
    }
    println(re)
    println(sum(8, 9))


    /**
     can not crash force
     */
    /**
    high order function
     */
    val jsonObject = JSONObject()
    jsonObject.tryCatch {
        val name = jsonObject.getString("name")
        val family = jsonObject.getString("family")
    }


}

val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

fun result(a: Int, b: Int, action: (Int, Int) -> Int): Int {
    return action(a, b)
}

/**
 inline function for no building object in memory
 */
inline fun JSONObject.tryCatch(code: () -> Unit) {
    try {
        code()
    }catch (e:JSONException){
        println(e)
    }
}
