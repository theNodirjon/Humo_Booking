package com.example.humo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.humo.databinding.DasturInfoBinding
import com.example.humo.utils.fragments.MainActivity

class DasturInfo : AppCompatActivity() {

    lateinit var binding: DasturInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DasturInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            startActivity(Intent(this@DasturInfo, MainActivity::class.java))
            finish()
        }

    }

}