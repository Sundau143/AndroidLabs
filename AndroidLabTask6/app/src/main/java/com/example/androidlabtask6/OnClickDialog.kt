package com.example.androidlabtask6

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class OnClickDialog (private val number: String) : DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Важливе повідомлення!")
            .setMessage("Ви натиснули на об'єкт із номером: $number")
            .setPositiveButton("OK", null)
            .create()

    }
}