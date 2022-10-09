package com.maskedcarrot.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*


@Serializable
data class Contest (
    val id: Int,
    val name: String,
    val platformId: Int,
    val url: String,
    val startTime: Long,
    val endTime: Long,
    val lastUpdated: Long
)

object Contests : Table() {
    val id = integer("id")
    val name = varchar("name", 128)
    val platformId = integer("platformId")
    val url = varchar("url", 256)
    val startTime = long("startTime")
    val endTime = long("endTime")
    val lastUpdated = long("lastUpdated")

    override val primaryKey = PrimaryKey(id)
}

