package br.com.pokedex.splash

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import br.com.pokedex.R
import br.com.pokedex.login.LoginActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        val ttb = AnimationUtils.loadAnimation(this, R.anim.anim_baixo_pra_cima)
        val stb = AnimationUtils.loadAnimation(this, R.anim.anim_surgir)
        val btu = AnimationUtils.loadAnimation(this,R.anim.anim_direita_pro_centro)

        val splash_logo = findViewById<ImageView>(R.id.splash_logo)
        val splash_pokemon = findViewById<ImageView>(R.id.splash_pokemon)
        val splash_pikachu = findViewById<ImageView>(R.id.splash_pikachu)


        splash_logo.startAnimation(ttb)
        splash_pokemon.startAnimation(ttb)
        splash_pikachu.startAnimation(stb)


        //TODO verificar se o user ta logado
        //exemplo de demora e chama a tela de login
        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 2000)

    }

}