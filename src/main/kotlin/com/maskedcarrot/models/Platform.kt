package com.maskedcarrot.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Platform (
    val id: Int,
    val name: String,
    val url: String,
    val logoUrl: String
)

object Platforms : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val url = varchar("name", 256)
    val logoUrl = varchar("logoUrl", 256)

    override val primaryKey = PrimaryKey(Contests.id)
}