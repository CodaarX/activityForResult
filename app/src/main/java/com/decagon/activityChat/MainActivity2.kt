package com.decagon.activityChat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.decagon.mymondayapplication.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        // get sent message from first activity in the bundle with getIntent, save to variable
        var receiver: Bundle? = getIntent().getExtras()

        // check if message received was empty. return if null
        if(receiver == null){
            return
        }

        // if not null, get the message received
        val question = receiver.getString("INPUT_KEY")

        // set text to received message
        textViewfield2.text = question
    }


    // send reply back to previous intent
    fun previousActivity(view: View){

        // compose intent for reply
        val intent: Intent = Intent(this, MainActivity::class.java)
        intent.putExtra("REPLY", editText2.getText().toString())

        // send code with intent
        setResult(243, intent)

        //simulate process death
        super.finish()
    }
}