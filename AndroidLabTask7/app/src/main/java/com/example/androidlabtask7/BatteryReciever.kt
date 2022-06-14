package com.example.androidlabtask7

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentManager
import kotlin.random.Random

class BatteryReciever  : BroadcastReceiver() {

    private lateinit var fragmentManager: FragmentManager

    override fun onReceive(context: Context?, intent: Intent?) {
        fragmentManager = (context as AppCompatActivity).supportFragmentManager
        when (intent?.action) {
            Intent.ACTION_BATTERY_LOW -> {
                batteryLow(context)
                showBatteryNotification(context)
            }
        }
    }

    private fun batteryLow(context: Context) {
        val batteryLowDailog = UniversalDialog("Низький заряд батареї")
        batteryLowDailog.show(fragmentManager, "battery_low")
    }

    private fun showBatteryNotification(context: Context) {
        val builder = NotificationCompat.Builder(context, "1")
            .setSmallIcon(com.google.android.material.R.drawable.mtrl_ic_error)
            .setContentTitle("Важливе повідомлення")
            .setContentText("Низький заряд батареї")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        NotificationManagerCompat.from(context).notify(Random.nextInt(), builder.build())
    }
}