package com.isaac.gadsleaderboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.isaac.gadsleaderboard.data.GadsRepository
import com.isaac.gadsleaderboard.data.models.LearnerHoursResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = GadsRepository()


    val learnersByHour = liveData(Dispatchers.IO) {
        val learnerResponse = repository.getTopLearnersByHour()
        emit(learnerResponse)
    }


    val learnersBySkillIQ = liveData(Dispatchers.IO) {
        val learnerResponse = repository.getTopLearnersBySkillIQ()
        emit(learnerResponse)
    }

    fun submitProjectDetails(
        firstName: String,
        lastName: String,
        email: String,
        projectLink : String
    ){
        viewModelScope.launch {
            repository.submitProjectToForm(email, firstName, lastName, projectLink)
        }
    }
}