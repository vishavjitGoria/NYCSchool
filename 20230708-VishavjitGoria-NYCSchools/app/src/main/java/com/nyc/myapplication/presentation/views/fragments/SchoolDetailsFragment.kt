package com.nyc.myapplication.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nyc.myapplication.databinding.FragmentSchoolListBinding
import com.nyc.myapplication.presentation.adapter.DetailsAdapter
import com.nyc.myapplication.presentation.viewmodels.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

const val KEY_DBN = "dbn"

@AndroidEntryPoint
class SchoolDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSchoolListBinding
    private val dataModel: AppViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSchoolListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dbn = requireArguments().getString("dbn")

        dbn?.let {
            dataModel.fetchSchoolDetailsByDbn(dbn)
        }


        dataModel.schoolDetails.observe(viewLifecycleOwner) {
            val data = it
            data?.let { item ->
                val adapter = DetailsAdapter(item)
                handleAdapter(adapter)
            }

        }

    }

    private fun handleAdapter(adapter: DetailsAdapter) {
        binding.rvHighSchool.setHasFixedSize(true)
        binding.rvHighSchool.adapter = adapter
    }
}