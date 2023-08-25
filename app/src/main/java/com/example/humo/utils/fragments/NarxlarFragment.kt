package com.example.humo.utils.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.humo.databinding.TalimFragmentBinding

class NarxlarFragment:AppCompatActivity(){

    lateinit var binding: TalimFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TalimFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.backBtn.setOnClickListener {
//            startActivity(Intent(this@TalimFragment, MainActivity::class.java))
//            finish()
//        }
//        binding.backBtn.setOnClickListener { startActivity(Intent(this@TalimFragment,MainActivity::class.java))
//            finish()
//        }

//        binding.backBtn.setOnClickListener {
//            startActivity(Intent(this@NarxlarFragment, MainActivity::class.java))
//            finish()
//
//        }
    }

//    @SuppressLint("InflateParams")
//    fun showDeveloperinfo() {
//        val dialogBuilder = AlertDialog.Builder(this)
//        val comingSonView = layoutInflater.inflate(R.layout.ishlab_chiqarishda, null)
//        dialogBuilder.setView(comingSonView)
//            .show()
//    }
//
//    //    Bu yerda qaysidur fan bosilsa "TEZ ORADA" degan habar chiqishi kerek edi!
//    override fun onContextItemSelected(item: MenuItem): Boolean {
//
//        when(item.itemId){
//
//            R.id.osteologiya->{ showDeveloperinfo() }
//            R.id.miologiya -> { showDeveloperinfo() }
//            R.id.splanchnologiya -> { showDeveloperinfo() }
//            R.id.nevrologiya -> { showDeveloperinfo() }
//            R.id.angiologiya -> { showDeveloperinfo() }
//
//        }
//
//        return super.onContextItemSelected(item)
//    }

}