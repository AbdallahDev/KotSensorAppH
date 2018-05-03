package com.jhr.abdallahsarayrah.kotsensorapph

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class Main3Activity : AppCompatActivity(), SensorEventListener {

    var manager: SensorManager? = null
    var sensor: Sensor? = null

    var xold = 0.0
    var yold = 0.0
    var zold = 0.0
    var ts = 3000.0
    var oT: Long = 0

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var xnew = event!!.values[0]
        var ynew = event.values[1]
        var znew = event.values[2]

        var ct: Long = System.currentTimeMillis()
        if ((ct - oT) > 100) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = manager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onResume() {
        super.onResume()

        manager!!.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()

        manager!!.unregisterListener(this)
    }
}
