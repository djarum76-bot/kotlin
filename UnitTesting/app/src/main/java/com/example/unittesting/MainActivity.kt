package com.example.unittesting

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.unittesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    companion object{
        private const val STATE = "state"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = MainViewModel(CuboidModel())

        binding.btnSave.setOnClickListener(this)
        binding.btnCalculateVolume.setOnClickListener(this)
        binding.btnCalculateSurfaceArea.setOnClickListener(this)
        binding.btnCalculateCircumference.setOnClickListener(this)

        if(savedInstanceState != null){
            val ini = savedInstanceState.getString(STATE)
            binding.tvResult.text = ini
        }
    }

    override fun onClick(v: View) {
        val length = binding.edtLength.text.toString().trim()
        val width = binding.edtWidth.text.toString().trim()
        val height = binding.edtHeight.text.toString().trim()

        when{
            length.isEmpty() -> binding.edtLength.error = "Field ini tidak boleh kosong"
            width.isEmpty() -> binding.edtWidth.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> binding.edtHeight.error = "Field ini tidak boleh kosong"
            else -> {
                val l = length.toDouble()
                val w = width.toDouble()
                val h = height.toDouble()

                when{
                    v.id == R.id.btn_save -> {
                        mainViewModel.save(l,w,h)
                        visible()
                    }

                    v.id == R.id.btn_calculate_volume -> {
                        binding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }

                    v.id == R.id.btn_calculate_surface_area -> {
                        binding.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }

                    v.id == R.id.btn_calculate_circumference -> {
                        binding.tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun gone() {
        binding.btnSave.visibility = View.VISIBLE
        binding.btnCalculateVolume.visibility = View.GONE
        binding.btnCalculateSurfaceArea.visibility = View.GONE
        binding.btnCalculateCircumference.visibility = View.GONE
    }

    private fun visible() {
        binding.btnSave.visibility = View.GONE
        binding.btnCalculateVolume.visibility = View.VISIBLE
        binding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        binding.btnCalculateCircumference.visibility = View.VISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE,binding.tvResult.text.toString())
    }
}