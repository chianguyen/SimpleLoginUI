package org.mp.simpleLoginUI

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_third.*
import java.util.*

class ThirdActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    override fun onInit(status: Int) {
        var result3: Int = textToSpeech3!!.isLanguageAvailable(Locale.US)

        if (result3 == TextToSpeech.LANG_MISSING_DATA
            || result3 == TextToSpeech.LANG_NOT_SUPPORTED){
            Log.e("TSS", "This language is not supported")
        }
    }

    var textToSpeech3: TextToSpeech? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        Toast.makeText(this, "Please register here!", Toast.LENGTH_SHORT).show()

        textToSpeech3 = TextToSpeech(this, this)

        btn_new_reg.setOnClickListener(View.OnClickListener {

            var new_name: String? = text_reg_name.text.toString()
            var new_pass: String? = text_pass.text.toString()
            var new_pass_confirm: String? = text_pass_confirm.text.toString()

            //make sure the fields are not empty
            if(new_pass != "" && new_name!=""){
                //check if password is the same as password confirm
                if(new_pass == new_pass_confirm) {

                    textToSpeech3!!.speak("Welcome $new_name! Going back to Login page!", TextToSpeech.QUEUE_FLUSH,null, "")

                    //Confirm registration
                    Toast.makeText(this, "Registration Successful!\nRedirecting back to Login page...", Toast.LENGTH_SHORT).show()

                    //Back to Login page
                    var myIntent4 = Intent(this, MainActivity::class.java)
                    startActivity(myIntent4)
                }

                else {
                    //Error announcement
                    textToSpeech3!!.speak("Registration failed! Please try again!", TextToSpeech.QUEUE_FLUSH,null, "")

                    //Error message
                    Toast.makeText(this, "Password confirmation failed. \nPlease try again", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                textToSpeech3!!.speak("Please fill in the form and try again!", TextToSpeech.QUEUE_FLUSH,null, "")
            }
        })
    }
}
