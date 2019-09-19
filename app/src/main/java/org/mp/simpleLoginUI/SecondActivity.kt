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
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    override fun onInit(status: Int) {
        var result2 : Int = textToSpeech2!!.isLanguageAvailable(Locale.US)
        if(result2 == TextToSpeech.LANG_MISSING_DATA
            || result2 == TextToSpeech.LANG_NOT_SUPPORTED){
            Log.e("TTS", "This language is not supported")
        }
    }

    var textToSpeech2: TextToSpeech? = null

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textToSpeech2 = TextToSpeech(this, this)

        //Putting correct name and password to Login Page (Second Activity)
        var nShow :String? = intent.extras?.getString("correctUsername")
        var pShow :String? = intent.extras?.getString("correctPassword")

        //Welcome message
        Toast.makeText(this, "Welcome $nShow!", Toast.LENGTH_SHORT).show()

        //Confirm Sentence to show username and password
        text_confirm.text = "You must be \"$nShow\" with password \"$pShow\"!"

        btn_logout.setOnClickListener(View.OnClickListener {

            textToSpeech2!!.speak("Logging out", TextToSpeech.QUEUE_FLUSH, null, "")

            var myIntent3 = Intent(this, MainActivity::class.java)
            startActivity(myIntent3)
            Toast.makeText(this, "Logging out...See you soon!", Toast.LENGTH_SHORT).show()
        })

    }
}
