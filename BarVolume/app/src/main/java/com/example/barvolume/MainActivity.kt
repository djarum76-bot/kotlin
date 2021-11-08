package com.example.barvolume

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding

    companion object{
        private const val TETAP = "tetap"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null){
            val ini = savedInstanceState.getString(TETAP)
            activityMainBinding.tvResult.text = ini
        }
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_calculate){
            val panjang = activityMainBinding.edtLength.text.toString().trim()
            val lebar = activityMainBinding.edtWidth.text.toString().trim()
            val tinggi = activityMainBinding.edtHeight.text.toString().trim()

            var kosong: Boolean = false

            if(TextUtils.isEmpty(panjang)){
                kosong = true
                activityMainBinding.edtLength.error = "ISIIII"
            }

            if(TextUtils.isEmpty(lebar)){
                kosong = true
                activityMainBinding.edtWidth.error = "ISIIII"
            }

            if(TextUtils.isEmpty(tinggi)){
                kosong = true
                activityMainBinding.edtHeight.error = "ISIIII"
            }

            if(!kosong){
                val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                activityMainBinding.tvResult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TETAP,activityMainBinding.tvResult.text.toString())
    }

}