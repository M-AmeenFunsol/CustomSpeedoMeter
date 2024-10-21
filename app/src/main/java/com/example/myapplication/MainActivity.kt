package com.example.myapplication

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.speedometer.setLabelConverter(SpeedometerView.LabelConverter { progress, maxProgress ->
            Math.round(progress).toInt().toString()
        })


// configure value range and ticks
        binding.speedometer.setMaxSpeed(100.0)
        binding.speedometer.setMajorTickStep(25.0)
        binding.speedometer.setMinorTicks(0)


// Configure value range colors
        binding.speedometer.addColoredRange(0.0, 50.0, Color.GREEN)
        binding.speedometer.addColoredRange(50.0, 75.0, Color.YELLOW)
        binding.speedometer.addColoredRange(75.0, 100.0, Color.RED)
        binding.speedometer.setSpeed(25.0, 2000, 500)


    }
}