package com.maskedcarrot.dao

import com.maskedcarrot.models.Platform

interface DAOPlatform {
    suspend fun fetchAllPlatforms(): List<Platform>
    suspend fun updatePlatformById(id: Int, platform: Platform)
    suspend fun deletePlatformById(id: Int)
    suspend fun deleteAllPlatforms()
    suspend fun addPlatform(platform: Platform)
    suspend fun addPlatformList(platformList: List<Platform>)
}