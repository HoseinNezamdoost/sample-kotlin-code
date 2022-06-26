package com.hosein.nzd.kotlinexample

/**
nested class
 */
class OuterNested {
    val myVar = 7

    class ChildOuterNested {
        fun myFunction() = 7
    }
}


/**
Inner class
 */
class OuterInner {
    val myVar = 7

    inner class ChildOuterInner {
        fun myFunction() = myVar
    }
}

fun main() {
    val childNested = OuterNested.ChildOuterNested()
    childNested.myFunction()
    //nested class can not override member outer class

    val childInner = OuterInner().ChildOuterInner()
    childInner.myFunction()
    //inner class can override member outer class
}