package com.example.soal_uts_bug_fixing

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.soal_uts_bug_fixing.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //tambahan untuk bug. menginisialisasi nama, identitas, dan gender
        val nama = intent.getStringExtra(AppointmentActivity.EXTRA_NAMA)
        val identitas = intent.getStringExtra(AppointmentActivity.EXTRA_IDENTITAS)
        val gender = intent.getStringExtra(AppointmentActivity.EXTRA_GENDER)

        val tipe = intent.getStringExtra(AppointmentActivity.EXTRA_TIPE)
        val alamat = intent.getStringExtra(AppointmentActivity.EXTRA_ALAMAT)
        val tanggal = intent.getStringExtra(AppointmentActivity.EXTRA_TANGGAL)
        val waktu = intent.getStringExtra(AppointmentActivity.EXTRA_WAKTU)


        with(binding){
            namaTxt.text = nama
            identitasTxt.text = identitas
            genderTxt.text = gender
            tipeTxt.text = tipe
            if(tipe=="Offline"){
                lokasiTitle.visibility = View.VISIBLE
                lokasiTxt.visibility = View.VISIBLE
                lokasiTxt.text = alamat
            }

            backBtn.setOnClickListener(){
                val intentToHome = Intent(this@ResultActivity, MainActivity::class.java)
                startActivity(intentToHome)
            }
        }

    }
}