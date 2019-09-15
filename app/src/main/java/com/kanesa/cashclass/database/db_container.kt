package com.kanesa.cashclass.database

import android.provider.BaseColumns

object db_container {
    class KasKelas: BaseColumns{
        companion object{
            val TABLE_NAME = "kasMasuk"
            val NAME_COLUMN = "Nama"
            val JUMLAH = "Jumlah"
            val TANGGAL = "Tanggal"
            val KET = "Keterangan"
        }
    }
}