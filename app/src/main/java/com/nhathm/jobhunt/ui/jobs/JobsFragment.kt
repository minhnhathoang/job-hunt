package com.nhathm.jobhunt.ui.jobs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.acxdev.commonFunction.util.view.RecyclerViewX.Companion.adapter
import com.nhathm.jobhunt.data.model.Job
import com.nhathm.jobhunt.databinding.FragmentJobsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class JobsFragment : Fragment() {

    private lateinit var binding: FragmentJobsBinding
    private val viewModel by viewModels<    JobsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJobsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mutableList = mutableListOf<Job>()
        mutableList.add(Job("Backend Java Developer", "Hanoi, Vietnam", "Remote", "Viettel Telecom"))
        mutableList.add(Job("Frontend React Developer", "Hanoi, Vietnam", "Remote", "Viettel Telecom"))
        mutableList.add(Job("Backend Java Developer", "Hanoi, Vietnam", "Remote", "Viettel Telecom"))

        binding.savedJobs.adapter(RecommendJobs(mutableList), 1)

        viewModel.test()
    }
}