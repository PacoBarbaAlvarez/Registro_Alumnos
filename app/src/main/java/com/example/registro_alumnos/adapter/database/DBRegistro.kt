package com.example.registro_alumnos.adapter.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(RegistroAlumnos::class), version = 1)

abstract  class DBRegistro: RoomDatabase() {

    abstract fun registroDao():RegistroDAO
}
