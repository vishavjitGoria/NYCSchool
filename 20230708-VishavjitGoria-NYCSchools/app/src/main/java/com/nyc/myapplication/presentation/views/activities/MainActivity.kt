package com.nyc.myapplication.presentation.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nyc.myapplication.R
import com.nyc.myapplication.presentation.viewmodels.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


//    private val dataModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        dataModel.fetchHighSchools()
//        dataModel.schoolList.observe(this) {
//            println("$it")
//        }

    }
}