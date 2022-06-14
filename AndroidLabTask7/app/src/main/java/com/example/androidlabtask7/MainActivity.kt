package com.example.androidlabtask7

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var airplaneModeReciever: AirplaneModeReciever
    lateinit var batteryReciever: BatteryReciever
    lateinit var onPowerReciever: OnPowerReciever

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            val name = "IMPORTANT"
            val descText = "Important notifications"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel("1", descText, importance)
            mChannel.description = descText

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }

        airplaneModeReciever = AirplaneModeReciever()
        batteryReciever = BatteryReciever()
        onPowerReciever = OnPowerReciever()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airplaneModeReciever, it)
        }

        IntentFilter(Intent.ACTION_BATTERY_LOW).also {
            registerReceiver(batteryReciever, it)
        }

        IntentFilter(Intent.ACTION_POWER_CONNECTED).also {
            registerReceiver(onPowerReciever, it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airplaneModeReciever)
        unregisterReceiver(batteryReciever)
        unregisterReceiver(onPowerReciever)
    }

}