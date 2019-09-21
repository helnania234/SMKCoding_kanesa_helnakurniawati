package com.kanesa.cashclass

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AbsenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahAbsen(absen: Absen)
    @Query("SELECT * FROM Absen")
    fun ambilSemuaAbsen(): LiveData<List<Absen>>
}