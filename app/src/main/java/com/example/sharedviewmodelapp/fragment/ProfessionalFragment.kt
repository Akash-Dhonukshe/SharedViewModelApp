package com.example.sharedviewmodelapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sharedviewmodelapp.R
import com.example.sharedviewmodelapp.databinding.FragmentProfessionalBinding
import com.example.sharedviewmodelapp.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfessionalFragment : Fragment() {

    //private val sharedViewModel :SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentProfessionalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfessionalBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


        binding.btnSubmit.setOnClickListener {
            sharedViewModel.saveData()
            sharedViewModel.sendProfessionalData(userExperience = binding.etExperience.text.toString(),
                userDomain = binding.etDomain.text.toString())
        }
    }

}