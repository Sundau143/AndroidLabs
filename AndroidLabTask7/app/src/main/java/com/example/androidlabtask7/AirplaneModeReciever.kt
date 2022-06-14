package com.example.androidlabtask7

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentManager
import kotlin.random.Random

class AirplaneModeReciever : BroadcastReceiver() {

    private lateinit var fragmentManager: FragmentManager
    private var status : String = ""

    override fun onReceive(context: Context?, intent: Intent?) {

        fragmentManager = (context as AppCompatActivity).supportFragmentManager
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return

        // перевіряємо статус режима "у літаку"
        if (isAirplaneModeEnabled) {
            status = "увімкнено"

        } else {
            status = "вимкнено"
        }

        when (intent.action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                airplaneModeChanged(context)
                showAirplaneNotification(context)
            }
        }
    }

    private fun airplaneModeChanged(context: Context) {
        val batteryLowDailog = UniversalDialog("Режим \"У літаку\": $status")
        batteryLowDailog.show(fragmentManager, "airplane_mode")
    }

    private fun showAirplaneNotification(context: Context) {
        val builder = NotificationCompat.Builder(context, "1")
            .setSmallIcon(com.google.android.material.R.drawable.mtrl_ic_error)
            .setContentTitle("Важливе повідомлення")
            .setContentText("Режим \"У літаку\": $status")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        NotificationManagerCompat.from(context).notify(Random.nextInt(), builder.build())
    }

}