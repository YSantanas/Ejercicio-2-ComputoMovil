package com.myss.regulus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext
import java.util.*

class suerteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suerte)

        val imagenSuerte = findViewById<ImageView>(R.id.recibeSuerte)

        imagenSuerte.setOnClickListener {
            val seed = System.currentTimeMillis()
            val randomWithSeed = Random(seed)

            val randomNumber = randomWithSeed.nextInt(4) + 1 // Generar número aleatorio entre 1 y 4

            when (randomNumber) {
                1 -> imagenSuerte.setImageResource(R.drawable.imagen_g)
                2 -> imagenSuerte.setImageResource(R.drawable.imagen_h)
                3 -> imagenSuerte.setImageResource(R.drawable.imagen_s)
                4 -> imagenSuerte.setImageResource(R.drawable.imagen_r)
                else -> imagenSuerte.setImageResource(R.drawable.defectoescudos) // Imagen por defecto si no coincide ningún caso
            }
        }

        val btna = findViewById<ImageButton>(R.id.btn_a)
        btna.setOnClickListener {
            onBackPressed()
        }
    }
}
