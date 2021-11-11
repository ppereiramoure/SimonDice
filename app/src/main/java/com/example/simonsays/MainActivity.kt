package com.example.simonsays

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(){
    var contadorRonda = 1

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
        val toast = Toast.makeText(applicationContext, "A la puta", Toast.LENGTH_SHORT)
        val toast3 = Toast.makeText(applicationContext, "Copiame", Toast.LENGTH_SHORT)
        val bot: Button = findViewById(R.id.BotonJugar)
        Log.d("Estado", "onCreate")

        jugar.setOnClickListener {
            finalizado = false
            reset(juego, jugador)
            añadirSecuencia(juego)
            empezarSecuencia(juego, listaBotones)
            toast3.show()
            visualizarRonda()
            bot.visibility = View.INVISIBLE
            Log.d("Estado", "Jugar")
        }

        comprobarSecuencia.setOnClickListener {
            Log.d("Estado", "Comprobar secuencia")
            contadorRonda++
            if (finalizado == false) {
                if (corrector(juego, jugador)) {
                    Log.d("Estado", "Ronda acertada")
                    añadirSecuencia(juego)
                    jugador.clear()
                    empezarSecuencia(juego, listaBotones)
                    visualizarRonda()
                } else {
                    finalizado = true
                    toast.show()
                    contadorRonda = 0
                    val bot: Button = findViewById(R.id.BotonJugar)
                    bot.visibility = View.VISIBLE
                    Log.d("Estado", "GAME OVER")
                }
            }

        }

        azul.setOnClickListener {
            secuenciaUsuario(jugador, 1)
        }
        amarillo.setOnClickListener {
            secuenciaUsuario(jugador, 2)
        }
        rojo.setOnClickListener {
            secuenciaUsuario(jugador, 3)
        }
        verde.setOnClickListener {
            secuenciaUsuario(jugador, 4)
        }

        }


    fun reset(sec: MutableList<Int>, secUsr: MutableList<Int>) {
        sec.clear()
        secUsr.clear()
        Log.d("Estado", "Reset del juego")
    }

    fun visualizarRonda(){
        findViewById<TextView>(R.id.Texto).text = contadorRonda.toString()
    }

    fun añadirSecuencia(sec: MutableList<Int>) {
        val numb = (1..4).random()
        sec.add(numb)
        Log.d("Estado", "Generar secuencia")
    }

    fun corrector(sec: MutableList<Int>, secUsr: MutableList<Int>): Boolean {
        return sec == secUsr
        Log.d("Estado", "Hacer comprobacion")
    }

    fun secuenciaUsuario(secUsr: MutableList<Int>, color: Int) {
        secUsr.add(color)
        Log.d("Estado", "Secuencia usuario")
    }

    fun empezarSecuencia(sec: MutableList<Int>, listaBotones: List<Button>) {
        Log.d("Estado", "Ejecutar")
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("Estado", "Ejecutar corrutina")
            for (color in sec) {
                delay(350)

                listaBotones[color - 1].backgroundTintList =
                    ColorStateList.valueOf(Color.parseColor("#FFFFFF"))
                Log.d("Estado", "Blancor")
                delay(800)
                when (color) {
                    1 -> listaBotones[color - 1].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("blue"))
                    2 -> listaBotones[color - 1].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("yellow"))
                    3 -> listaBotones[color - 1].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("red"))
                    4 -> listaBotones[color - 1].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("green"))
                }
            }
            var t = Toast.makeText(applicationContext, "Repitir", Toast.LENGTH_SHORT)
            t.show()
            Log.d("Estado", "Repitir")

        }
    }
}






