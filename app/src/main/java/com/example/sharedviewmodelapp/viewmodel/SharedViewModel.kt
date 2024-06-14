package com.example.sharedviewmodelapp.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sharedviewmodelapp.model.NewsResponse
import com.example.sharedviewmodelapp.retrofit.ApiInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val repository : ApiInterface
): ViewModel() {
    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()

    var education = MutableLiveData<String>()
    var degree = MutableLiveData<String>()

    var experience = MutableLiveData<String>()
    var domain = MutableLiveData<String>()

    var article = MutableLiveData<NewsResponse>()


    fun sendPersonalData(userFName : String, userLName : String){
        firstName.value = userFName
        lastName.value = userLName
    }

    fun sendEducationalData(userEducation : String, userDegree : String){
        education.value = userEducation
        degree.value = userDegree
    }

    fun sendProfessionalData(userExperience : String, userDomain : String){
        experience.value = userExperience
        domain.value = userDomain
    }

    fun saveData(){
        sharedPreferences.edit().putString("name", firstName.value.toString()).apply()
        sharedPreferences.edit().putString("lastName", lastName.value.toString()).apply()

        sharedPreferences.edit().putString("education", education.value.toString()).apply()
        sharedPreferences.edit().putString("degree", degree.value.toString()).apply()

        sharedPreferences.edit().putString("experience", experience.value.toString()).apply()
        sharedPreferences.edit().putString("domain", domain.value.toString()).apply()
    }

    fun getArticle(){}


}