package com.example.humo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.humo.databinding.TestIshlaBinding
import com.example.humo.utils.fragments.MainActivity

class TestUchun : AppCompatActivity() {

    lateinit var binding: TestIshlaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TestIshlaBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            startActivity(Intent(this@TestUchun, MainActivity::class.java))
            finish()
        }

    }


}