package com.example.androidlabtask5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidlabtask5.databinding.ThirdTabFragmentBinding

class ThirdTabFragment : Fragment() {
    private var _binding: ThirdTabFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ThirdTabFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}