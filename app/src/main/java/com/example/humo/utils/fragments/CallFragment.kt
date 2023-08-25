package com.example.humo.utils.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.humo.databinding.CalllItemBinding

class CallFragment : AppCompatActivity() {

    lateinit var binding: CalllItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalllItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn1.setOnClickListener {
            startActivity(Intent(this@CallFragment, MainActivity::class.java))
        }

        binding.instagram.setOnClickListener {
            openInstagramProfile()
        }


    }

    fun openInstagramProfile() {

        val uri = Uri.parse("https://www.instagram.com/akbarshokh_abdurashidov/")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        intent.setPackage("com.instagram.android") // Package name of Instagram app

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            // Instagram app not found on the device
            // Handle the situation or prompt the user to install Instagram
        }
    }

}