package com.example.sharedviewmodelapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sharedviewmodelapp.R
import com.example.sharedviewmodelapp.databinding.FragmentEducationBinding
import com.example.sharedviewmodelapp.viewmodel.SharedViewModel

class EducationFragment : Fragment() {
   private lateinit var binding: FragmentEducationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEducationBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        sharedViewModel.firstName.observe(viewLifecycleOwner, Observer {
            binding.etFirstName.setText(it.toString())
        })

        sharedViewModel.lastName.observe(viewLifecycleOwner, Observer {
            binding.etLastName.setText(it.toString())
        })

        binding.btnNext.setOnClickListener {
            sharedViewModel.saveData()
            sharedViewModel.sendEducationalData(userEducation = binding.etEducation.text.toString(),
                userDegree = binding.etDegree.text.toString()
                )
            findNavController().navigate(R.id.action_educationFragment_to_professionalFragment)
        }

    }

}