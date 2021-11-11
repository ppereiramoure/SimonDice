package com.example.simonsays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(){
    val contadorRonda: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var juego = ArrayList<Int>()
        var jugador = ArrayList<Int>()
        var finalizado = false
        val jugar = findViewById<Button>(R.id.BotonJugar)
        val comprobarSecuencia = findViewById<Button>(R.id.BotonCorroborar)
        val azul = findViewById<Button>(R.id.BotonAzul)
        val rojo = findViewById<Button>(R.id.BotonRojo)
        val amarillo = findViewById<Button>(R.id.BotonAmarillo)
        val verde = findViewById<Button>(R.id.BotonVerde)
        val listaBotones = listOf(rojo, verde, amarillo, azul)
        val toast = Toast.makeText(applicationContext, "GAME OVER", Toast.LENGTH_SHORT)
        val toast3 = Toast.makeText(applicationContext, "Repite la secuencia", Toast.LENGTH_SHORT)
        val bot: Button = findViewById(R.id.BotonJugar)
        Log.d("Estado", "onCreate")

        }

    }
    private fun Comenzar(){
        Log.i ("Estado" , "Empieza la partida")
        val mostrarRonda: TextView = findViewById(R.id.Texto)
        mostrarRonda.text = contadorRonda.toString()

    }

    fun ejecutarSecuencia(){
        Log.i ("Estado" , "Empieza la partida")
    }

    fun añadirSecuencia(){

    }

    fun mostrarRonda(){

    }

    fun checkSecuencia(){

    }




}
