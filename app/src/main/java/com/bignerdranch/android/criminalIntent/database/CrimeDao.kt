package com.bignerdranch.android.criminalIntent.database

import androidx.room.Dao
import androidx.room.Query
import com.bignerdranch.android.criminalIntent.Crime
import java.util.*
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Update

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
    fun getCrimes(): LiveData<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:uuid)")
    fun getCrime(uuid: UUID): LiveData<Crime?>

    @Update
    fun updateCrime(crime:Crime)

    @Insert
    fun addCrime(crime: Crime)

}