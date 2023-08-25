package com.example.humo.utils.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.humo.R
import com.example.humo.databinding.VizalarBinding

class VizaFragment: AppCompatActivity() {

    lateinit var binding: VizalarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VizalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        R.id.xitoy_img=findViewById<.layout>(DetailsFragmet)

        binding.backBtn1.setOnClickListener {
            startActivity(Intent(this@VizaFragment, MainActivity::class.java))
            finish()
        }

    }

}