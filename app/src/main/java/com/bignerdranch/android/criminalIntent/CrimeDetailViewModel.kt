package com.bignerdranch.android.criminalIntent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.criminalIntent.CrimeRepository
import java.io.File
import java.util.*

class CrimeDetailViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData: LiveData<Crime?> =
        Transformations.switchMap(crimeIdLiveData){ crimeIdLiveData ->
            crimeRepository.getCrime(crimeIdLiveData)
        }
    fun loadCrime(crimeId:UUID){
        crimeIdLiveData.value=crimeId
    }
    fun saveCrime(crime:Crime){
        crimeRepository.updateCrime(crime)
    }
    fun getPhotoFile(crime: Crime):File{
        return crimeRepository.getPhotoFile(crime)
    }


}