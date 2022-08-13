package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.stripe.Stripe

fun main() {

    Stripe.apiKey = "pk_test_51KkDEgCpXNrjS0vATGw0tV5pind5LMe49nAqDe41T3brgZc7J9bv7MQAopciLojJZFuKY4wUWUCAf2GVLoBXdLyw00LjLJRdni"

    embeddedServer(Netty, port = System.getenv("PORT").toInt(), host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}
