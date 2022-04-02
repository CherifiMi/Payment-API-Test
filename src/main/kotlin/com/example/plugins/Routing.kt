package com.example.plugins

import com.stripe.Stripe
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import com.stripe.model.PaymentIntent

import com.stripe.param.PaymentIntentCreateParams
import io.ktor.features.*
import io.ktor.gson.*


fun Application.configureRouting() {




    routing {
        install(ContentNegotiation) {
            gson()
        }

        payment()

        get("/") {
            call.respondText("Hello World!")
        }
    }
}

fun Route.payment() {

    route("/stripe") {
        get {
            call.respondText("Hello Stripe!")
        }
        get("{id}") {

        }

        post {

            val formParameters = call.receiveParameters()

            val amount = formParameters["amount"]?.toLong()
            val currency = formParameters["currency"].toString()

            val params: PaymentIntentCreateParams =
                PaymentIntentCreateParams.builder()
                    .setAmount(amount)
                    .setCurrency(currency)
                    .build()

            val intent: PaymentIntent = PaymentIntent.create(params)
            var clientSecret: String = intent.clientSecret
            call.respond(clientSecret)
        }

        delete("{id}") {

        }
    }
}

