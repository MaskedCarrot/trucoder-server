package com.maskedcarrot.dao

import com.maskedcarrot.models.Contest

interface DAOContest {
    suspend fun fetchAllContest(): List<Contest>
    suspend fun insertContestList(contestList: List<Contest>)
    suspend fun deleteAllContests()
}