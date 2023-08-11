package com.nyc.myapplication.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nyc.myapplication.data.model.GetSchoolDetails
import com.nyc.myapplication.data.model.HighSchoolList
import com.nyc.myapplication.domain.GetDetailsUseCase
import com.nyc.myapplication.domain.GetHighSchoolUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val getHighSchoolUseCase: GetHighSchoolUseCase,
    private val getDetailsUseCase: GetDetailsUseCase
) :
    ViewModel() {

    private val _schoolList = MutableLiveData<HighSchoolList>()
    val schoolList: LiveData<HighSchoolList> get() = _schoolList

    private val _schoolDetails = MutableLiveData<GetSchoolDetails>()
    val schoolDetails: LiveData<GetSchoolDetails> get() = _schoolDetails

    fun fetchHighSchools() {
        viewModelScope.launch {
            val data = getHighSchoolUseCase()
            _schoolList.postValue(data.body())
        }
    }

    fun fetchSchoolDetailsByDbn(dbn: String) {
        viewModelScope.launch {
            val data = getDetailsUseCase(dbn)
            _schoolDetails.postValue(data.body())
        }
    }


}