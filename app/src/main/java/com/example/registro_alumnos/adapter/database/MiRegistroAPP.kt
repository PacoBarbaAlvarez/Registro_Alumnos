package com.example.registro_alumnos.adapter.database

import android.app.Application
import androidx.room.Room

class MiRegistroAPP: Application() {
    companion object{
        lateinit var database: DBRegistro
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, DBRegistro::class.java, "DBLista").build()
    }
}