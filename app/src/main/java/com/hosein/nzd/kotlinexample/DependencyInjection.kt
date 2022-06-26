package com.hosein.nzd.kotlinexample

class EmailService : MessageService {
    override fun sendMessages(message: String, receiver: String) {
        println("sent email to $receiver with message $message")
    }
}

class SmsService : MessageService {
    override fun sendMessages(message: String, receiver: String) {
        println("sent sms to $receiver with message $message")
    }
}

interface MessageService {
    fun sendMessages(message: String, receiver: String)
}

object Injector{
    fun inject() : MessageService{
        return EmailService()
    }
}

class Activity1(private val messageService: MessageService) {
    fun sendMessage(message: String, receiver: String) {
        messageService.sendMessages(message, receiver)
    }
}

class Activity2(private val messageService: MessageService) {
    fun sendMessage(message: String, receiver: String) {
        messageService.sendMessages(message, receiver)
    }
}

fun main() {
    val activity1 = Activity1(Injector.inject())
    activity1.sendMessage("hello world", "hosein nzd")

    val activity2 = Activity2(Injector.inject())
    activity2.sendMessage("hello guys!", "samin MM")
}