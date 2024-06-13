package com.example.sharedviewmodelapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()



    fun sendData(userFName : String, userLName : String){
        firstName.value = userFName
        lastName.value = userLName
    }
}