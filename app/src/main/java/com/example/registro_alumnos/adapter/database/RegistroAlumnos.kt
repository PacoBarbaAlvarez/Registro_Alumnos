package com.example.registro_alumnos.adapter.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="registro_alumnos")

data class RegistroAlumnos(
    @PrimaryKey(autoGenerate = true)
    var identificador:Int = 0,
    var nombre:String="",
    var curso:String = "",
    var apellidos:String="false",


    )