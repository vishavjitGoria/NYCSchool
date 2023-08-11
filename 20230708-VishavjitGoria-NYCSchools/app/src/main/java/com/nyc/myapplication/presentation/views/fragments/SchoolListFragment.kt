package com.nyc.myapplication.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.nyc.myapplication.databinding.FragmentSchoolListBinding
import com.nyc.myapplication.presentation.adapter.SchoolAdapter
import com.nyc.myapplication.presentation.viewmodels.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolListFragment : Fragment() {

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

        dataModel.fetchHighSchools()

        val navController = NavHostFragment.findNavController(this)

        binding.ivBack.setOnClickListener {
            navController.popBackStack()
        }

        binding.lvLoading.visibility = View.VISIBLE
        binding.rvHighSchool.visibility = View.INVISIBLE

        dataModel.schoolList.observe(viewLifecycleOwner) {

            binding.lvLoading.visibility = View.INVISIBLE
            binding.rvHighSchool.visibility = View.VISIBLE

            val data = it
            data?.let { item ->
                val adapter = SchoolAdapter(item, navController)
                handleAdapter(adapter)
            }
        }


    }

    private fun handleAdapter(adapter: SchoolAdapter) {
        binding.rvHighSchool.setHasFixedSize(true)
        binding.rvHighSchool.adapter = adapter
    }

}