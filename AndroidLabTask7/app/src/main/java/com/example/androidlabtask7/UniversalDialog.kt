package com.example.androidlabtask7

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class UniversalDialog (private val message: String) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Важлива інформація")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .create()
    }
}