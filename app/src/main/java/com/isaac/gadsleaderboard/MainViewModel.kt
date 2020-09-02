package com.isaac.gadsleaderboard

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.isaac.gadsleaderboard.data.GadsRepository
import com.isaac.gadsleaderboard.data.models.LearnerHoursResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val repository = GadsRepository()
    private var _responseLiveData = MutableLiveData<Response<Void>>()
    val responseLiveData: LiveData<Response<Void>> = _responseLiveData


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
            val response = repository.submitProjectToForm(email, firstName, lastName, projectLink)
            _responseLiveData.value = response
        }

    }
}