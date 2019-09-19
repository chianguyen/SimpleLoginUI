package org.mp.simpleLoginUI

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    //Text to Speech
    override fun onInit(status: Int) {
        var result1 : Int = textToSpeech!!.isLanguageAvailable(Locale.US)
        if(result1 == TextToSpeech.LANG_MISSING_DATA
             || result1 == TextToSpeech.LANG_NOT_SUPPORTED){
            Log.e("TTS", "This language is not supported")
        }
    }

    var textToSpeech: TextToSpeech? = null
    //

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize textToSpeech variable
        textToSpeech = TextToSpeech(this, this)

        //If user pressed LOGIN button
        btn_login.setOnClickListener(View.OnClickListener {

            var username: String = userName.text.toString()
            var password: String = passWord.text.toString()

            //Check username and password
            if(username == "chi" && password == "123"){

                //call the text to say something when the button is clicked
                textToSpeech!!.speak("Welcome $username. Logging in", TextToSpeech.QUEUE_FLUSH, null, "")

                Toast.makeText(this, "Login Successfully. Welcome " + username, Toast.LENGTH_SHORT).show()

                var myIntent = Intent(this, SecondActivity::class.java)
                myIntent.putExtra("correctUsername", username)
                myIntent.putExtra("correctPassword", password)
                startActivity(myIntent)
            }

            else {
                textToSpeech!!.speak("Login failed! Please try again!", TextToSpeech.QUEUE_FLUSH, null, "")
                Toast.makeText(this, "Wrong credentials. Please try again", Toast.LENGTH_SHORT).show()
            }

        })

        //In case user pressed REGISTER button
        btn_register.setOnClickListener(View.OnClickListener {

            var myIntent2 = Intent(this, ThirdActivity::class.java)
            startActivity(myIntent2)

        })

    }
}
