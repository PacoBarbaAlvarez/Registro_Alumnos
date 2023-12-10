package com.example.registro_alumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registro_alumnos.adapter.database.ActivityWithMenus
import com.example.registro_alumnos.adapter.database.MiRegistroAPP
import com.example.registro_alumnos.adapter.database.RegistroAlumnos
import com.example.registro_alumnos.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {
    lateinit var binding : ActivityMainBinding
    lateinit var elementos: MutableList<RegistroAlumnos>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val nombre = binding.nombre.text.toString()
            val apellidos = binding.apellidos.text.toString()
            val curso = binding.curso.text.toString()

            addElemento(RegistroAlumnos(nombre = nombre, apellidos = apellidos, curso = curso))
        }
        elementos = ArrayList()

    }

    fun addElemento(elemento:RegistroAlumnos){
        CoroutineScope(Dispatchers.IO).launch{
            MiRegistroAPP.database.registroDao().addElemento(elemento)
        }

    }

}