package com.nhathm.jobhunt.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager.widget.ViewPager
import com.acxdev.commonFunction.adapter.PageAdapter
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior
import com.nhathm.jobhunt.R
import com.nhathm.jobhunt.data.api.UserApi
import com.nhathm.jobhunt.databinding.ActivityMainBinding
import com.nhathm.jobhunt.ui.jobs.JobsFragment
import com.nhathm.jobhunt.ui.menu.MenuFragment
import com.nhathm.jobhunt.ui.people.PeopleFragment
import com.nhathm.jobhunt.ui.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val page = PageAdapter(supportFragmentManager)
        page.adds(JobsFragment(), PeopleFragment(), ProfileFragment(), MenuFragment())

        binding.viewPager.adapter = page
        binding.viewPager.offscreenPageLimit = 4
        binding.viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.bottomNavigation.menu.getItem(0).isChecked = true
                    }
                    1 -> {
                        binding.bottomNavigation.menu.getItem(1).isChecked = true
                    }
                    2 -> {
                        binding.bottomNavigation.menu.getItem(2).isChecked = true
                    }
                    3 -> {
                        binding.bottomNavigation.menu.getItem(3).isChecked = true
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_jobs -> binding.viewPager.currentItem = 0
                R.id.navigation_people -> binding.viewPager.currentItem = 1
                R.id.navigation_profile -> binding.viewPager.currentItem = 2
                R.id.navigation_menu -> binding.viewPager.currentItem = 3
            }
            renderFragment()
            true
        }
    }

    private fun renderFragment() {
        val layoutParams = binding.bottomNavigation.layoutParams as CoordinatorLayout.LayoutParams
        val bottomNavigation = layoutParams.behavior as HideBottomViewOnScrollBehavior

        bottomNavigation.slideUp(binding.bottomNavigation)
    }
}