package com.decagon.activityChat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.decagon.mymondayapplication.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A mini chat application between two activities implementing start activity for result
 * @param userInput takes user input to be sent to activity 2
 *
 */

class MainActivity : AppCompatActivity() {

    val AUTHENTICATION_CODE = 554
    var handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // display the activity layout
        setContentView(R.layout.activity_main)
    }

    // Clicking the send button activate this function to send message
    fun onClickNextActivity(view: View){

        // gets user input and format it to string
        var userInput = userInputActivityA.getText().toString()

        // save intent to variable
        var intent = Intent(this, MainActivity2:: class.java)

        // send extra message with intent
        intent.putExtra("INPUT_KEY", userInput)

        // initiate intent with authentication
        startActivityForResult(intent, AUTHENTICATION_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        // ensures request code and result code are authentic
        if(requestCode == AUTHENTICATION_CODE && resultCode == 243){

            // change the text only if authorized
            reply.text = data?.getStringExtra("REPLY")
        }
        // change the text only if authorized
        // delay the time to initiate the process death
        handler.postDelayed({super.finish()}, 3000)
    }

}