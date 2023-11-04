package com.twister.topic

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.twister.topic.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import routes.registerPlayerRoutes

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::module) //host = "0.0.0.0"
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation){
        json()
    }


    configureRouting()
    registerPlayerRoutes()
}
