package com.example.sharedviewmodelapp.fragment

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sharedviewmodelapp.R
import com.example.sharedviewmodelapp.databinding.FragmentPersonalBinding
import com.example.sharedviewmodelapp.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PersonalFragment : Fragment() {

    private lateinit var binding: FragmentPersonalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.btnNext.setOnClickListener {
            sharedViewModel.sendPersonalData(userFName = binding.etFirstName.text.toString(),
                userLName = binding.etLastName.text.toString())
            findNavController().navigate(R.id.action_personalFragment_to_educationFragment)
        }
    }
}