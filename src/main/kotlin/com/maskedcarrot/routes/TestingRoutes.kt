package com.maskedcarrot.routes

import com.maskedcarrot.controller.ContestDataController
import com.maskedcarrot.models.Contest
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val contestDataController = ContestDataController()

fun Route.testingRouting() {
    route("/test") {
        get {
            val obj1 = Contest(
                1,
                "test contest 1",
                2342,
                "www.test.com/contest1",
                23423423,
                2342423423,
                234234234
            )
            val obj2 =Contest(
                12,
                "test contest 12",
                234,
                "www.test.com/contest12",
                34534534,
                345345345,
                3453534534
            )
            val testingContestList = listOf(obj1, obj2)
            val text = Json.encodeToString(testingContestList)
            contestDataController.processNewContestData(text)
        }
    }
}