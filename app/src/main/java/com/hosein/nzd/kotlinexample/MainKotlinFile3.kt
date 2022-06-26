package com.hosein.nzd.kotlinexample

fun main() {
    val array = listOf<Int>(7, 10, 17, 23, 45, 56, 82)
    var x = 0

    for (item in array) {
        println(item)
    }

    for (i in array.indices) {
        //println(array[i])
        println(i)
    }

    for (item in array.size - 1 downTo 0) {
        //println(array[item])
        println(item)
    }

    for (item in array.size - 1 downTo 0 step 2) {
        println(item)
    }

    array.forEach {
        println(it)
    } //or next line

    array.forEach { item ->
        println(item)
    }

    array.forEachIndexed { index, item ->
        println(item)
        println(index)
    }

    while (x < 7) {
        println(x)
        x++
    }

    do {
        println(x)
        x++
    } while (x < 7)

    for (i in array.iterator()) {
        if (i == 17)
            continue
        println(i)
    }

    for (i in array.iterator()) {
        if (i == 17)
            break
        println(i)
    }

    for (i in 1..1) {
        var base = "*"
        println(base)

        for (i2 in 0..3) {

            base += "*"
            println(base)
        }

    }

}