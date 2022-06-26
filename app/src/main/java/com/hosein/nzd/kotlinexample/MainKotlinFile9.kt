package com.hosein.nzd.kotlinexample

import kotlin.properties.Delegates

//delegate

class Users {
    //this is for initial last override
    val name: String by lazy {
        println("lazy")
        "hosein"
    }

    //delegate observable
    //this is for real change for call me
    var name2 : String by Delegates.observable("<no name>"){
        property, oldValue, newValue -> println("$oldValue to $newValue")
    }

    //delegate to variable
    var newName : String = "default"
    var oldName : String by this::newName

}

fun main() {
    val users = Users()
    println(users.name)
    println(users.name)

    users.name2 = "hosein"
    users.name2 = "sadra"
    users.name2 = "mamad"

    users.oldName = "ramin"
    println(users.newName)
}