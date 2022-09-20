package com.example.trainingmaterialdesing
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trainingmaterialdesing.databinding.ActivityMainBinding
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.slider?.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener{
            override fun onStartTrackingTouch(slider: RangeSlider) {
                binding?.selectedPart?.text = getString(R.string.action)
            }
            override fun onStopTrackingTouch(slider: RangeSlider) {
                binding?.selectedPart?.text = getString(R.string.beforeAction)
            }
        })
        binding?.slider?.addOnChangeListener{rangeSlider, value, fromUser ->
            val values = rangeSlider.values
            val valueFrom = values[0].toString()
            val valueTo = values[1].toString()
            binding?.descSelectedPart?.text = "${getString(R.string.yourSelected)} " +
                    "$valueFrom ${getString(R.string.to)} $valueTo"
        }
    }
}