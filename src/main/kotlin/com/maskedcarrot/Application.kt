package com.maskedcarrot

import com.maskedcarrot.dao.DatabaseFactory
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.maskedcarrot.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        DatabaseFactory.init()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
