package com.maskedcarrot.dao

import com.maskedcarrot.dao.DatabaseFactory.dbQuery
import com.maskedcarrot.models.Platform
import com.maskedcarrot.models.Platforms
import org.jetbrains.exposed.sql.*

class DAOPlatformImp : DAOPlatform {
    override suspend fun fetchAllPlatforms(): List<Platform> = dbQuery {
        Platforms.selectAll().map(::resultRowToPlatform)
    }

    override suspend fun updatePlatformById(id: Int, platform: Platform) {
        Platforms.update({Platforms.id eq id}) {
            it[this.name] = platform.name
            it[this.url] = platform.url
            it[this.logoUrl] = platform.logoUrl
        }
    }

    override suspend fun deletePlatformById(id: Int): Unit = dbQuery {
        Platforms.deleteWhere { Platforms.id eq id }
    }

    override suspend fun deleteAllPlatforms() {
        Platforms.deleteAll()
    }

    override suspend fun addPlatform(platform: Platform): Unit = dbQuery {
        Platforms.insert {
            it[this.name] = platform.name
            it[this.url] = platform.url
            it[this.logoUrl] = platform.logoUrl
        }
    }

    override suspend fun addPlatformList(platformList: List<Platform>) {
        Platforms.batchInsert(data = platformList, shouldReturnGeneratedValues = false) {platform ->
            this[Platforms.name] = platform.name
            this[Platforms.url] = platform.url
            this[Platforms.logoUrl] = platform.logoUrl
        }
    }


    private fun resultRowToPlatform(row: ResultRow) = Platform(
        id = row[Platforms.id],
        name = row[Platforms.name],
        url = row[Platforms.url],
        logoUrl = row[Platforms.logoUrl]
    )
}