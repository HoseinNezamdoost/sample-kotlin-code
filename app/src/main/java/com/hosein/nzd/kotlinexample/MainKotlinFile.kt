package com.hosein.nzd.kotlinexample

import java.lang.AssertionError

//public static final in kotlin
const val name = "hosein-nzd.ir"
//last init
lateinit var family: String

fun main() {
    val variable = 10
    println("Hello Kotlin ${sumExample(variable, 20)}")
    println("I`m variable $variable")

    val myClass = MyClass("wqwq", 18)
    println(myClass.returner())

    //nullable variable(?)
    val nullable: String?;
    nullable = null

    //init classes

    val child = Child("reza", "gav")
    println(child.returner())

    //SetterAndGetter
    val modelKt = ModelKt()
    modelKt.name = "hosein"
    println(modelKt.name)

    val modelKt2 = ModelKt2("mamad", "dadashi")
    println(modelKt2.fullName)

    val modelKt3 = ModelKt3()
    println(modelKt3.variable)
}

fun sum(variable1: Int, variable2: Int): Int {
    return variable1 + variable2
}

//or ...
fun sumExample(variable1: Int, variable2: Int) = variable1 + variable2

class MyClass(var variable1: String, var variable2: Int) {

    init {
        variable1 = "I`m hosein nezamdoost My age is $variable2"
    }

    fun returner() = variable1

}

//=====================================================

open class Parent(var firstname: String, lastname: String) {

    val name = "My name is $firstname and my lastname is $lastname"

    init {
        firstname = "sadra"
    }

    init {
        firstname = "mohammad"
    }
}

class Child(firstname: String, var lastname: String) : Parent(firstname, lastname) {

    fun returner(): String {
        return firstname + lastname
    }

}

//=========================GetterAndSetter============================
class ModelKt {

    var name = "hosein"
        set(name) {
            field = "$name $family" //field = hosein
        }
        get() = field.toUpperCase()

    var family = "nezamdoost" // field = nezamdoost

}

class ModelKt2(var name: String, var family: String) {

    val fullName
        get() = "$name $family"
}

class ModelKt3 {
    private var _variable: Map<String, String>? = null
    public val variable : Map<String, String>
    get() {
        if (_variable == null){
            _variable = HashMap()
        }
        return _variable?:throw AssertionError("error")
    }
}
