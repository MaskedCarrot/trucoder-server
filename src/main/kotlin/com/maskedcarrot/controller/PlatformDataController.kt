package com.maskedcarrot.controller

import com.maskedcarrot.dao.DAOContestImp
import com.maskedcarrot.dao.DAOPlatform
import com.maskedcarrot.dao.DAOPlatformImp
import com.maskedcarrot.models.Platform
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class PlatformDataController {
    private val daoPlatform: DAOPlatform = DAOPlatformImp()

    suspend fun getAllPlatformData() = daoPlatform.fetchAllPlatforms()

    suspend fun deleteAllPlatforms() = daoPlatform.deleteAllPlatforms()

    suspend fun processNewPlatformData(newPlatformData: String) {
        val newPlatformList = Json.decodeFromString<List<Platform>>(newPlatformData)
        daoPlatform.addPlatformList(newPlatformList)
    }
}