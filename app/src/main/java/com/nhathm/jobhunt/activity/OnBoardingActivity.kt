package com.nhathm.jobhunt.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.acxdev.commonFunction.adapter.PageAdapter
import com.acxdev.commonFunction.util.FunctionX.Companion.useCurrentTheme
import com.nhathm.jobhunt.databinding.ActivityOnBoardingBinding
import com.nhathm.jobhunt.ui.onboarding.OnBoardingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        useCurrentTheme()

        val page = PageAdapter(supportFragmentManager)
        page.adds(OnBoardingFragment(), OnBoardingFragment(), OnBoardingFragment())

        binding.viewPager.adapter = page
        binding.dotsIndicator.setViewPager(binding.viewPager)
        var currentPage = 0
        binding.buttonGetStarted.setOnClickListener {
            if (currentPage < 2) {
                currentPage += 1
                binding.viewPager.currentItem = currentPage
            } else {
                finish()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> currentPage = 0
                    1 -> currentPage = 1
                    2 -> currentPage = 2
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        binding.textSkipIntro.setOnClickListener {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}