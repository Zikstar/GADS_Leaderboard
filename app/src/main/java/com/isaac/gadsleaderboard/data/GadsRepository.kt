package com.isaac.gadsleaderboard.data

class GadsRepository {

    private var gadsApiClient = RetrofitClient.gadsApi
    private var googleFormSubmitClient = RetrofitClient.googleFormsApi


    suspend fun getTopLearnersByHour() = gadsApiClient.getTopLearnersByHours()
    suspend fun getTopLearnersBySkillIQ() = gadsApiClient.getTopLearnersBySkillIQ()


    suspend fun submitProjectToForm(emailAddress: String,
                                    firstName: String,
                                    lastName: String,
                                    linkToProject: String)=
        googleFormSubmitClient.submitProject(emailAddress, firstName, lastName, linkToProject)
}