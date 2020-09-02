package com.isaac.gadsleaderboard.data

import retrofit2.Response

class GadsRepository {

    private var gadsApiClient = RetrofitClient.gadsApi
    private var googleFormSubmitClient = RetrofitClient.googleFormsApi


    suspend fun getTopLearnersByHour() = gadsApiClient.getTopLearnersByHours()
    suspend fun getTopLearnersBySkillIQ() = gadsApiClient.getTopLearnersBySkillIQ()


    suspend fun submitProjectToForm(emailAddress: String,
                                    firstName: String,
                                    lastName: String,
                                    linkToProject: String) : Response<Void> =
        googleFormSubmitClient.submitProject(emailAddress, firstName, lastName, linkToProject)
}