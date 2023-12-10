package com.example.registro_alumnos.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registro_alumnos.R
import com.example.registro_alumnos.adapter.database.ActivityWithMenus
import com.example.registro_alumnos.adapter.database.MiRegistroAPP
import com.example.registro_alumnos.adapter.database.RegistroAlumnos
import com.example.registro_alumnos.databinding.ActivityMainBinding
import com.example.registro_alumnos.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateActivity : ActivityWithMenus() {
    lateinit var binding: ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actualizar.setOnClickListener {
            updateLista(RegistroAlumnos(
                nombre = binding.nalumno.text.toString(),
                curso = binding.nuevocurso.text.toString()))
        }

    }

    fun updateLista(elemento: RegistroAlumnos) {
        CoroutineScope(Dispatchers.IO).launch {
            val n = elemento.nombre
            val recoveryalumno = MiRegistroAPP.database.registroDao().getElementoId(n)
            recoveryalumno.curso = binding.nuevocurso.text.toString()
            MiRegistroAPP.database.registroDao().updateLista(elemento)
        }
    }
}