package com.example.humo.utils.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.humo.databinding.DetailFragmentBinding

class DetailsFragmet:AppCompatActivity() {

    lateinit var binding: DetailFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn1.setOnClickListener {
            startActivity(Intent(this@DetailsFragmet, MainActivity::class.java))
            finish()
        }


    }

}