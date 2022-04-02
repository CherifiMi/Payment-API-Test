package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.stripe.Stripe

fun main() {

    Stripe.apiKey = "sk_test_51Kjbz4AuBgxbOOjROIn4zNleCC0igpCGxHlNKT1CMNLEwRr9eWutouJo9tmoercTGAYQT996szY90UyowpuQKF8500KiUpRbFv"

    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}
