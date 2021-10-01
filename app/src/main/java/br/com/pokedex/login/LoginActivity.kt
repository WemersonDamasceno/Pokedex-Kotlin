package br.com.pokedex.login


import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.pokedex.R
import br.com.pokedex.pagina_inicial.view.PaginaInicialActivity
import java.util.*


class LoginActivity : AppCompatActivity() {
    private lateinit var isAnimation: AnimationDrawable
    private lateinit var imageView:ImageView
    private lateinit var input_senha: EditText
    private lateinit var input_email: EditText
    private lateinit var btn_login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        imageView = findViewById(R.id.imageView)
        input_senha = findViewById(R.id.input_senha)
        input_email = findViewById(R.id.input_email)
        btn_login = findViewById(R.id.btn_login)


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
            val intent = Intent(baseContext, PaginaInicialActivity::class.java)
            startActivity(intent)
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
