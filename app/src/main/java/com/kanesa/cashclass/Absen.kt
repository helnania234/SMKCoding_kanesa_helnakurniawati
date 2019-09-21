package com.kanesa.cashclass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Absen (
    @PrimaryKey
    val absenId: Int? = null,
    var Bendahara: String?,
    var WaliKelas: String?,
    var Kelas: String?,
    var biaya: String?

    )