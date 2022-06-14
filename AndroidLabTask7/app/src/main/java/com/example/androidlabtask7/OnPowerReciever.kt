package com.example.androidlabtask7

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Debug
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentManager
import kotlin.random.Random

class OnPowerReciever: BroadcastReceiver() {

    private lateinit var fragmentManager: FragmentManager

    override fun onReceive(context: Context?, intent: Intent?) {

        fragmentManager = (context as AppCompatActivity).supportFragmentManager
        when (intent?.action) {
            Intent.ACTION_POWER_CONNECTED -> {
                onPower(context)
                showPowerNotification(context)
            }
        }
    }

    private fun onPower(context: Context) {
        val onPowerDailog = UniversalDialog("Під'єднано зарядний пристрій")
        onPowerDailog.show(fragmentManager, "on_power")
    }

    private fun showPowerNotification(context: Context) {
        val builder = NotificationCompat.Builder(context, "1")
            .setSmallIcon(com.google.android.material.R.drawable.mtrl_ic_error)
            .setContentTitle("Важливе повідомлення")
            .setContentText("Під'єднано зарядний пристрій")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        NotificationManagerCompat.from(context).notify(Random.nextInt(), builder.build())
    }

}
