package com.example.mini_app_uts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mini_app_uts.databinding.ActivityMainHomeBinding

class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra(RegistrationActivity.it_nama)
        val bb_now = intent.getIntExtra(RegistrationActivity.it_bb_now, 0)
        val bb_future = intent.getIntExtra(RegistrationActivity.it_bb_future, 0)
        val it_calories = intent.getIntExtra(RegistrationActivity.it_calories,0)
        val it_date = intent.getStringExtra(RegistrationActivity.it_date)
        val it_goals = intent.getStringExtra(RegistrationActivity.it_goals)
        val unit1 = intent.getStringExtra(RegistrationActivity.it_unit1)
        val unit2 = intent.getStringExtra(RegistrationActivity.it_unit2)


        var jumlahkalorimakan = intent.getStringExtra("jumlahkalorimakan")

        val jumlahkalorimakannew = jumlahkalorimakan?.toIntOrNull() ?: "0"

        var jumlahkaloriworkout = intent.getStringExtra("jumlahkaloriworkout")

        val jumlahkaloriworkoutnew = jumlahkaloriworkout?.toIntOrNull() ?: "0"
        val selisih = Math.abs(bb_now - bb_future)

        with(binding){
            textNama.text = "$nama"
            weightNow.text = "$bb_now"
            weightNowUnit.text = "$unit1"
            weightFuture.text = "$bb_future"
            weightFutureUnit.text = "$unit2"
            selish.text = "$selisih"
            selisihUnit.text = "$unit1"
            calories.text = "$it_calories"
            date.text = "$it_date"
            goals.text = "$it_goals"

            food.setText(jumlahkalorimakannew.toString() + " Kcal")
            exercise.setText(jumlahkaloriworkoutnew.toString() + " kcal")

            hmBtMakan.setOnClickListener {
                val Intent = Intent(this@MainHomeActivity, MakanActivity::class.java)
                startActivity(Intent)
            }
            }
    }
}