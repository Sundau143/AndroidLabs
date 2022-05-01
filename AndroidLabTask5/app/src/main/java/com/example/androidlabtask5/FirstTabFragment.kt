package com.example.androidlabtask5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidlabtask5.databinding.FirstTabFragmentBinding

class FirstTabFragment : Fragment() {
    private var _binding: FirstTabFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FirstTabFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}