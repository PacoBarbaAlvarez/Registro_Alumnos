package com.example.registro_alumnos.adapter

import android.os.Bundle
import com.example.registro_alumnos.R
import com.example.registro_alumnos.adapter.database.ActivityWithMenus
import com.example.registro_alumnos.adapter.database.MiRegistroAPP
import com.example.registro_alumnos.adapter.database.RegistroAlumnos
import com.example.registro_alumnos.databinding.ActivityDeleteBinding
import com.example.registro_alumnos.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteActivity : ActivityWithMenus() {
    lateinit var binding: ActivityDeleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_delete)

        binding.beliminar.setOnClickListener {
            deleteLista(
                RegistroAlumnos(
                    nombre = binding.neliminar.text.toString()
                )
            )
        }
    }

    fun deleteLista(RegistrarAlumno:RegistroAlumnos){
        CoroutineScope(Dispatchers.IO).launch {
            val n= RegistrarAlumno.nombre
            val recoveryalumno= MiRegistroAPP.database.registroDao().getElementoId(n)
            recoveryalumno.curso=binding.neliminar.text.toString()
            MiRegistroAPP.database.registroDao().updateLista(recoveryalumno)
        }
    }
}