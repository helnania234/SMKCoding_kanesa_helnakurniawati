package com.kanesa.cashclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_pegaturan.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Pegaturan : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var absenDao: AbsenDao? = null


    private var nmBendahara: String? = ""
    private var nmWaliKelas: String? = ""
    private var nmKelas: String? = ""
    private var nmbiaya: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pegaturan)
        setSpinner()
        close.setOnClickListener {
            keluar()
        }
        btnpengatur.setOnClickListener {
            save()
        }
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(this)
        absenDao = db?.AbsenDao()
    }

    private fun keluar() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun setSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.hari,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        hari.adapter = adapter
    }

    fun save() {
        nmBendahara = bendahara.text.toString()
        nmWaliKelas = WaliKelas.text.toString()
        nmKelas = kelas.text.toString()
        nmbiaya = biaya.text.toString()
        when {
            nmBendahara!!.isEmpty() -> bendahara.error = "Nama tidak boleh kosong"
            nmWaliKelas!!.isEmpty() -> WaliKelas.error = "Nama tidak boleh kosong"
            nmKelas!!.isEmpty() -> kelas.error = "kelas tidak boleh kosong"
            nmbiaya!!.isEmpty() -> biaya.error = "biaya tidak boleh kosong"

            else -> {

                val absen = Absen(
                    Bendahara = nmBendahara,
                    WaliKelas = nmWaliKelas,
                    Kelas = nmKelas,
                    biaya = nmbiaya
                )
                simpanData(absen)

            }

        }
    }

    private fun simpanData(absen: Absen): Job {
        return GlobalScope.launch {
            absenDao?.tambahAbsen(absen)
        }
    }
}
