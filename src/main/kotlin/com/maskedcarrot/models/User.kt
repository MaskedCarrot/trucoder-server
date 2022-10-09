package com.maskedcarrot.models

import org.jetbrains.exposed.sql.Table

data class User(val id: String, val subscribedPlatform: Int)

object Users : Table() {
    val id = varchar("id", 128)
    val subscribedPlatforms = integer("subscribedPlatforms")
}