package com.example.registro_alumnos.adapter.database

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.registro_alumnos.MainActivity
import com.example.registro_alumnos.R
import com.example.registro_alumnos.adapter.DeleteActivity
import com.example.registro_alumnos.adapter.UpdateActivity

open class ActivityWithMenus: AppCompatActivity() {

    companion object{
        var actividadActual = 0;

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Relacionamos la clas con el layout del menu que hemos creado

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        for(i in 0  until  menu.size()){

            if(i== actividadActual)menu.getItem(i).isEnabled = false
            else menu.getItem(i).isEnabled = true
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.añadir -> {
                actividadActual = 0;
                //Hacemos que se abra la pantalla del listado de parques:
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.actualizar -> {
                actividadActual = 1;
                //Hacemos que se abra la pantalla del formulario para añadir parques:
                val intent = Intent(this, UpdateActivity::class.java)
                startActivity(intent)
                true
            }

            R.id.eliminar -> {
                actividadActual = 1;
                //Hacemos que se abra la pantalla del formulario para añadir parques:
                val intent = Intent(this, DeleteActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}