package com.maskedcarrot.dao

import com.maskedcarrot.dao.DatabaseFactory.dbQuery
import com.maskedcarrot.models.Contest
import com.maskedcarrot.models.Contests
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.selectAll

class DAOContestImp : DAOContest {
    override suspend fun fetchAllContest(): List<Contest> = dbQuery {
        Contests.selectAll().map(::resultRowToContest)
    }

    override suspend fun insertContestList(contestList: List<Contest>): Unit = dbQuery {
        Contests.batchInsert(data = contestList, shouldReturnGeneratedValues = false) { contest ->
            this[Contests.id] = contest.id
            this[Contests.name] = contest.name
            this[Contests.platformId] = contest.platformId
            this[Contests.url] = contest.url
            this[Contests.startTime] = contest.startTime
            this[Contests.endTime] = contest.endTime
            this[Contests.lastUpdated] = contest.lastUpdated
        }
    }

    override suspend fun deleteAllContests(): Unit = dbQuery {
        Contests.deleteAll()
    }

    private fun resultRowToContest(row: ResultRow) = Contest(
        id = row[Contests.id],
        name = row[Contests.name],
        platformId = row[Contests.platformId],
        url = row[Contests.url],
        startTime = row[Contests.startTime],
        endTime = row[Contests.endTime],
        lastUpdated = row[Contests.lastUpdated]
    )
}