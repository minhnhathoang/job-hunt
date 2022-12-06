package com.nhathm.jobhunt.ui.jobs

import androidx.lifecycle.viewModelScope
import com.nhathm.jobhunt.base.BaseViewModel
import com.nhathm.jobhunt.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobsViewModel @Inject constructor(private val userRepository: UserRepository) : BaseViewModel() {

    fun test() {
        viewModelScope.launch() {
            userRepository.login()
        }
    }
}