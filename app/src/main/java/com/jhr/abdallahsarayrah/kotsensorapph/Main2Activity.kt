package com.jhr.abdallahsarayrah.kotsensorapph

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class Main2Activity : AppCompatActivity(), SensorEventListener {

    var manager: SensorManager? = null
    var sensor: Sensor? = null


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        textView1.text = event!!.values[0].toString()
        textView2.text = event!!.values[1].toString()
        textView3.text = event!!.values[2].toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

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
