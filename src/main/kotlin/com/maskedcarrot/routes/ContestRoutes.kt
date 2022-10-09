package com.maskedcarrot.routes

import com.maskedcarrot.controller.ContestDataController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val contestDataController = ContestDataController()

fun Route.contestRouting() {
    route("/contests") {
        get {
            val contestListString = Json.encodeToString(contestDataController.getAllContestData())
            call.respond(status = HttpStatusCode.OK, message = contestListString)
        }

        post("/text") {
            val newContestData = call.receiveText()
            contestDataController.processNewContestData(newContestData)
        }
    }
}