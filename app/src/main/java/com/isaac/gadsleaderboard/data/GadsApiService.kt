package com.isaac.gadsleaderboard.data

import com.isaac.gadsleaderboard.data.models.LearnerSkillLevelResponse
import com.isaac.gadsleaderboard.data.models.LearnerHoursResponse
import retrofit2.http.GET

interface GadsApiService {
    @GET("/api/hours")
    suspend fun getTopLearnersByHours(): LearnerHoursResponse

    @GET("/api/skilliq")
    suspend fun getTopLearnersBySkillIQ() : LearnerSkillLevelResponse
}