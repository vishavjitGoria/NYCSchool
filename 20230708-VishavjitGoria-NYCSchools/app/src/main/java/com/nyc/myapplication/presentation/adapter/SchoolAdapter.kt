package com.nyc.myapplication.presentation.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.nyc.myapplication.R
import com.nyc.myapplication.data.model.HighSchoolListItem
import com.nyc.myapplication.databinding.ItemSchoolBinding
import com.nyc.myapplication.presentation.views.fragments.KEY_DBN

class SchoolAdapter(
    private val data: List<HighSchoolListItem>,
    private val navController: NavController
) : RecyclerView.Adapter<SchoolAdapter.ViewHolder>() {

    class ViewHolder(_binding: ItemSchoolBinding) : RecyclerView.ViewHolder(_binding.root) {

        val binding: ItemSchoolBinding

        init {
            binding = _binding
        }

        fun bind(highSchoolListItem: HighSchoolListItem, navController: NavController) {

            binding.tvSchoolName.text = "Name:: ${highSchoolListItem.school_name}"
            binding.tvSchoolDesc.text = "Description:: ${highSchoolListItem.overview_paragraph}"

            binding.root.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(KEY_DBN, highSchoolListItem.dbn)
                navController.navigate(
                    R.id.action_schoolListFragment_to_shcoolDetailsFragment,
                    bundle
                )
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemSchoolBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], navController)
    }
}