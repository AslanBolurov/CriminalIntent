package com.bignerdranch.android.criminalIntent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.bignerdranch.android.criminalIntent.databinding.ActivityMainBinding
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), CrimeListFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentFragment= supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment==null){
            val fragment= CrimeListFragment.newInstance()
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.fragment_container,fragment)
//                .commit()
            supportFragmentManager.commit{
                add(R.id.fragment_container,fragment)
            }

        }
    }



    override fun onCrimeSelected(crimeId: UUID) {
        val fragment=CrimeFragment.newInstance(crimeId)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container,fragment)
//            .addToBackStack(null)
//            .commit()
        supportFragmentManager.commit {
            replace(R.id.fragment_container,fragment)
            addToBackStack(null)
        }
    }
}