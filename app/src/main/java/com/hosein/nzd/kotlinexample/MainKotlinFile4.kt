package com.hosein.nzd.kotlinexample

//singleton object in kotlin

object ClassSingleTon {
    var x = 0
    fun test() = x++
}

//static member in kotlin
class MemberStatic {
    companion object {

        @JvmStatic
        var name = "hosein"

        @JvmStatic
        fun test(): String {
            return "nezamdoost"
        }
    }
}

val anonymousClass = object {
    fun myFun() {

    }
}

fun main() {
    println(ClassSingleTon.test())
    println(ClassSingleTon.test())
    println(ClassSingleTon.test())

    println(MemberStatic.name)
    println(MemberStatic.test())
}