package com.hosein.nzd.kotlinexample

//data class

data class MyClass021(val id:Int, val name:String, val age:Int){
    val myVar = "sdsds"
}

fun main() {
    val myClass021 = MyClass021(0 , "reza" , 33)
    val myClass022 = MyClass021(0 , "reza" , 33)
    println(myClass021 == myClass022)

    //copy data class
    val myClass023 = MyClass021(0 , "reza" , 33)
    val myClass024 = myClass023.copy(name = "sadra" , id = 4)
    println(myClass024)

    //destructing declaration
    val myClass025 = MyClass021(0 , "reza" , 33)
    val (id , name) = myClass025
    println("$name $id")
}