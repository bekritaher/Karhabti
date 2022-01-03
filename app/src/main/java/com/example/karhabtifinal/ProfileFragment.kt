package com.example.karhabtifinal

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.karhabtifinal.R
import androidx.navigation.fragment.findNavController
import com.example.karhabtifinal.databinding.FragmentAccueilBinding
import com.example.karhabtifinal.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.buttonModifierProfile.setOnClickListener {
            findNavController().navigate(R.id.profile_to_modifierprofile)
        }
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


//        binding.buttonModifierProfile.setOnClickListener {
//            //   findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
