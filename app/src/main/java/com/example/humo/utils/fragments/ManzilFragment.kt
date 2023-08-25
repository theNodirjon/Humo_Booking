package com.example.humo.utils.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.humo.R
import com.example.humo.repo.DataRepository


class ManzilFragment : Fragment() {

     val DataRepository=DataRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_manzil, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Live Data ni tinglash uchun Observer qo'shamiz
        DataRepository.dataLiveData.observe(viewLifecycleOwner, Observer { data ->
            // Live Data o'zgarishi bo'lganda ma'lumotni yangilaymiz

        })

//        button.setOnClickListener {
//            // Live Data ni o'zgartiramiz
//            DataRepository.dataLiveData.value = "Ma'lumot Fragment Two dan"
//        }
    }

}