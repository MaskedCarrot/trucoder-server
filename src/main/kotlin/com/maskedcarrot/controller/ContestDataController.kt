package com.maskedcarrot.controller

import com.maskedcarrot.dao.DAOContest
import com.maskedcarrot.dao.DAOContestImp
import com.maskedcarrot.models.Contest
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ContestDataController {
    private val daoContest: DAOContest = DAOContestImp()

    suspend fun processNewContestData(newContestData: String) {
        val newContestList = Json.decodeFromString<List<Contest>>(newContestData)
        daoContest.deleteAllContests()
        daoContest.insertContestList(newContestList)
    }

    suspend fun getAllContestData(): List<Contest> = daoContest.fetchAllContest()
}