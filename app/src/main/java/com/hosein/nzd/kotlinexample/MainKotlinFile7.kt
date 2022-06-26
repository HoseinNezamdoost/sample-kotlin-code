package com.hosein.nzd.kotlinexample
//call safe
fun main() {

    val myVar : String? = null
    //if(myVar != null) == your variable?
    myVar?.length
    //This is for print "null"
    println(myVar?.length?:"null")


}