package com.example.mini_app_uts

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import com.example.mini_app_uts.databinding.ActivityRegistrationBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    companion object {
        const val it_nama = "nama"
        const val it_bb_now = "bb_now"
        const val it_bb_future = "bb_future"
        const val it_calories = "calories"
        const val it_date = "dates"
        const val it_goals = "goals"
        const val it_unit1 = "unit1"
        const val it_unit2 = "unit2"
    }

    private val units = arrayOf(
        "Kg",
        "Lb",
        "Pound"
    )
    private val goals = arrayOf(
        "Bulk",
        "Maintain",
        "Cut"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val unitsAdapter =
                ArrayAdapter(this@RegistrationActivity, R.layout.simple_spinner_item, units)
            val goalsAdapter =
                ArrayAdapter(this@RegistrationActivity, R.layout.simple_spinner_item, goals)

            unitsAdapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
            goalsAdapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)

            satuanBeratNow.adapter = unitsAdapter
            satuanBeratFuture.adapter = unitsAdapter
            tujuan.adapter = goalsAdapter

            val intent = Intent(this@RegistrationActivity, MainHomeActivity::class.java)

            // Inisialisasi CalendarView
            date.setOnDateChangeListener { view, year, month, dayOfMonth ->
                // Membuat objek Calendar
                val calendar = Calendar.getInstance()
                calendar.set(year, month, dayOfMonth)

                // Mengonversi tanggal menjadi string dengan format yang diinginkan (misalnya, "dd MMMM yyyy")
                val dateFormat = SimpleDateFormat("dd MMMM yyyy")

            submitButton.setOnClickListener {
                val nama = nama.text.toString()
                val bb_now = beratNow.text.toString()
                val bb_future = beratFuture.text.toString()
                val calories = calories.text.toString()
                val goals = tujuan.selectedItem.toString()
                val unit1 = satuanBeratNow.selectedItem.toString()
                val unit2 = satuanBeratFuture.selectedItem.toString()
                val dates = dateFormat.format(calendar.time)

                    if (nama.isEmpty() || bb_now.isEmpty() || bb_future.isEmpty() || calories.isEmpty()) {
                        Toast.makeText(applicationContext, "Cant Empty!", Toast.LENGTH_SHORT).show()
                    } else {
                        val bb_now_int = bb_now.toInt()
                        val bb_future_int = bb_future.toInt()
                        val calories_int = calories.toInt()
                        intent.putExtra(it_nama, nama)
                        intent.putExtra(it_bb_now, bb_now_int)
                        intent.putExtra(it_bb_future, bb_future_int)
                        intent.putExtra(it_calories, calories_int)
                        intent.putExtra(it_unit1, unit1)
                        intent.putExtra(it_unit2, unit2)
                        intent.putExtra(it_goals, goals)
                        intent.putExtra(it_date, dates)
                        startActivity(intent)

                    }
                }
            }
        }
    }
}
