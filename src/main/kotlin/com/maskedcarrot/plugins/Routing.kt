package com.maskedcarrot.plugins

import com.maskedcarrot.routes.contestRouting
import com.maskedcarrot.routes.testingRouting
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World! This is TruCoder-server")
        }
        contestRouting()
        testingRouting()
    }
}
