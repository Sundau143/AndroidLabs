package com.example.androidlabtask5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidlabtask5.databinding.SecondTabFragmentBinding

class SecondTabFragment : Fragment() {
    private var _binding: SecondTabFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SecondTabFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}