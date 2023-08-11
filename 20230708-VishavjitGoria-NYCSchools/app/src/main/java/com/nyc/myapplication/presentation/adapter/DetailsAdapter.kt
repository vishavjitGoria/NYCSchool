package com.nyc.myapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nyc.myapplication.data.model.GetSchoolDetailsItem
import com.nyc.myapplication.databinding.ItemSchoolBinding
import com.nyc.myapplication.databinding.ItemSchoolDetailsBinding

class DetailsAdapter(
    private val data: List<GetSchoolDetailsItem>
) : RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {

    class ViewHolder(_binding: ItemSchoolDetailsBinding) : RecyclerView.ViewHolder(_binding.root) {

        val binding: ItemSchoolDetailsBinding

        init {
            binding = _binding
        }

        fun bind(schoolDetails: GetSchoolDetailsItem) {

            binding.tvSchoolName.text = "SchoolName:: ${schoolDetails.school_name}"
            binding.numOfSatTestTakers.text =
                "num_of_sat_test_takers:: ${schoolDetails.num_of_sat_test_takers}"
            binding.satCriticalReadingAvgScore.text =
                "sat_critical_reading_avg_score:: ${schoolDetails.sat_critical_reading_avg_score}"
            binding.satMathAvgScore.text =
                "sat_math_avg_score:: ${schoolDetails.sat_math_avg_score}"
            binding.satWritingAvgScore.text =
                "sat_writing_avg_score:: ${schoolDetails.sat_writing_avg_score}"


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemSchoolDetailsBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}