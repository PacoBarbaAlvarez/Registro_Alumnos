package com.example.registro_alumnos.adapter.database
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RegistroDAO {

    @Query("SELECT * FROM registro_alumnos")
    fun getALLElements(): MutableList<RegistroAlumnos>


    @Insert
    fun addElemento(elemento: RegistroAlumnos): Long

    @Query("SELECT * FROM registro_alumnos WHERE nombre like :nombre")
    fun getElementoId(nombre:String): RegistroAlumnos

    @Update
    fun updateLista(elemento: RegistroAlumnos):Int

    @Delete
    fun deleteLista(elemento: RegistroAlumnos):Int
}