package br.com.pokedex.login


import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import br.com.pokedex.R
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*


class LoginActivity : AppCompatActivity() {
    private lateinit var isAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        var mediaPlayer: MediaPlayer

        var qtdToquesImg = 0
        imageView.setOnClickListener { v ->
            Toast.makeText(v.context, "Não faça isso por 3 vezes!", Toast.LENGTH_LONG).show()
            qtdToquesImg++
            if(qtdToquesImg >=3) {
                qtdToquesImg =0
                //Fazer o som
                mediaPlayer = MediaPlayer.create(baseContext, R.raw.som)
                mediaPlayer.start()
                //Reproduzir a "animacao"
                imageView.setImageResource(R.drawable.animation_item)
                isAnimation = imageView.drawable as AnimationDrawable
                isAnimation.start()


                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        //vibrar
                        /*val vibra: Vibrator? = getSystemService(VIBRATOR_SERVICE) as Vibrator?
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            vibra?.vibrate(VibrationEffect.createOneShot(2000,10))
                        }else{
                            vibra?.vibrate(3)
                        }*/
                        qtdToquesImg = 0
                        imageView.setImageResource(R.drawable.picachu)
                        mediaPlayer.stop()
                        isAnimation.stop()
                    }
                }, 2100)
            }
        }

        validarEmailSenha()


        input_senha.setOnFocusChangeListener { view: View, b: Boolean ->
            if(b){
                imageView.setImageResource(R.drawable.picachu_cobrindo_olhos)
            }else{
                imageView.setImageResource(R.drawable.picachu)
            }
        }

        input_email.setOnFocusChangeListener { _: View, b: Boolean ->
            if(b){
                if(input_email.text!!.contains("@"))
                    imageView.setImageResource(R.drawable.picachu_email_inicio)
                if(input_email.text!!.contains(".com"))
                    imageView.setImageResource(R.drawable.picachu_email_final)
            }else{
                imageView.setImageResource(R.drawable.picachu)
            }
        }



        btn_login.setOnClickListener{
            //TODO Fazer animacao antes de trocar a tela
        }


    }

    private fun validarEmailSenha() {
        input_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.contains("@"))
                    imageView.setImageResource(R.drawable.picachu_email_inicio)
                else
                    imageView.setImageResource(R.drawable.picachu)
                if (s.contains(".com"))
                    imageView.setImageResource(R.drawable.picachu_email_final)

            }
        })
    }


}