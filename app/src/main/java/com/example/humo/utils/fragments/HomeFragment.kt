package com.example.humo.utils.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.humo.R
import com.example.humo.databinding.FragmentHomeBinding
import com.example.humo.repo.DataRepository


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val DataRepository = DataRepository()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Live Data ni tinglash uchun Observer qo'shamiz
        DataRepository.dataLiveData.observe(viewLifecycleOwner, Observer { data ->
            // Live Data o'zgarishi bo'lganda ma'lumotni yangilaymiz
        })

//        binding.bolimlar.setOnClickListener {
//            // Live Data ni o'zgartiramiz
//            DataRepository.dataLiveData.value = "Ma'lumot Fragment One dan"
//            showDeveloperinfo()
//        }


    }

    fun showDeveloperinfo() {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val comingSonView = layoutInflater.inflate(R.layout.ishlab_chiqarishda, null)
        dialogBuilder.setView(comingSonView)
            .show()
    }

}