package com.example.geminibattery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log

class BatteryInfoReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
            val batteryStatus = intent.extras

            // Battery level
            val level = batteryStatus?.getInt(BatteryManager.EXTRA_LEVEL) ?: -1
            val scale = batteryStatus?.getInt(BatteryManager.EXTRA_SCALE) ?: -1
            val batteryPct = (level / scale.toFloat()) * 100

            // Charging status
            val status = batteryStatus?.getInt(BatteryManager.EXTRA_STATUS)
            val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL

            // Charging source
            val chargePlug = batteryStatus?.getInt(BatteryManager.EXTRA_PLUGGED, -1)
            val usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
            val acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC

            // Other information (you can access more extras)
            val technology = batteryStatus?.getString(BatteryManager.EXTRA_TECHNOLOGY)
            val temperature = batteryStatus?.getInt(BatteryManager.EXTRA_TEMPERATURE)

            Log.d("BatteryInfo", "Battery level: $batteryPct%")
            Log.d("BatteryInfo", "Charging: $isCharging")
            Log.d("BatteryInfo", "USB charge: $usbCharge")
            Log.d("BatteryInfo", "AC charge: $acCharge")
            Log.d("BatteryInfo", "Technology: $technology")
            Log.d("BatteryInfo", "Temperature: $temperature °C")
        }
    }
}
