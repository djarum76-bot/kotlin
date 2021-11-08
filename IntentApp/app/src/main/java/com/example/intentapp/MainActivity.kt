package com.example.intentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    companion object{
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnMoveActivity.setOnClickListener(this)
        activityMainBinding.btnMoveDataActivity.setOnClickListener(this)
        activityMainBinding.btnMoveActivityObject.setOnClickListener(this)
        activityMainBinding.btnDialNumber.setOnClickListener(this)
        activityMainBinding.btnMoveForResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                val pindah = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(pindah)
            }

            R.id.btn_move_data_activity -> {
                val go = Intent(this@MainActivity, MoveDataActivity::class.java)
                go.putExtra(MoveDataActivity.NAMA,"Habil")
                go.putExtra(MoveDataActivity.UMUR,19)
                startActivity(go)
            }

            R.id.btn_move_activity_object -> {
                val orang = Person("Habil",19,"habil0105@gmail.com","Payakumbuh")

                val ayo = Intent(this@MainActivity,MoveWithObjectActivity::class.java)
                ayo.putExtra(MoveWithObjectActivity.ORANG,orang)
                startActivity(ayo)
            }

            R.id.btn_dial_number -> {
                val phone = "082268159542"

                val dial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                startActivity(dial)
            }

            R.id.btn_move_for_result -> {
                val moveForResult = Intent(this@MainActivity,MoveForResultActivity::class.java)
                startActivityForResult(moveForResult, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE){
            if(resultCode == MoveForResultActivity.RESULT_CODE){
                val akhir = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
                activityMainBinding.tvResult.text = "Hasil = $akhir"
            }
        }
    }
}