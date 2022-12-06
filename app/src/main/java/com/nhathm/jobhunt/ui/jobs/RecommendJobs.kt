package com.nhathm.jobhunt.ui.jobs

import com.acxdev.commonFunction.adapter.BaseAdapter
import com.bumptech.glide.Glide
import com.nhathm.jobhunt.data.model.Job
import com.nhathm.jobhunt.databinding.ItemRecommendedJobBinding

class RecommendJobs(private val jobList: MutableList<Job>): BaseAdapter<ItemRecommendedJobBinding>(ItemRecommendedJobBinding::inflate, jobList) {
    override fun onBindViewHolder(holder: ViewHolder<ItemRecommendedJobBinding>, position: Int) {
        val job = jobList[position]
        holder.binding.title.text = "Backend Java Developer"
        holder.binding.address.text = "Hanoi, Vietnam"
        holder.binding.jobType.text = "Remote"
        holder.binding.company.text = "Viettel Telecom"
        Glide.with(holder.binding.root.context).load("https://play-lh.googleusercontent.com/nCVVCbeSI14qEvNnvvgkkbvfBJximn04qoPRw8GZjC7zeoKxOgEtjqsID_DDtNfkjyo").into(holder.binding.photo)
    }
}