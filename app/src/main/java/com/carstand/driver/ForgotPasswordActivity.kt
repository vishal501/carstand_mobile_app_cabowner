package com.carstand.driver

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.carstand.driver.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.emailRadioBtn -> {
                    showEmailInput()
                }
                R.id.phoneNoRadioBtn -> {
                    showPhoneNoInput()
                }
            }
        }
    }

    // Function to show email input and hide phone input
    private fun showEmailInput() {
        binding.etEmail.visibility = View.VISIBLE
        binding.etPhoneNo.visibility = View.INVISIBLE
        binding.tvEmailTitle.visibility = View.VISIBLE
        binding.tvPhoneNoTitle.visibility = View.INVISIBLE
    }

    // Function to show phone number input and hide email input
    private fun showPhoneNoInput() {
        binding.etEmail.visibility = View.INVISIBLE
        binding.etPhoneNo.visibility = View.VISIBLE
        binding.tvEmailTitle.visibility = View.INVISIBLE
        binding.tvPhoneNoTitle.visibility = View.VISIBLE
    }

}