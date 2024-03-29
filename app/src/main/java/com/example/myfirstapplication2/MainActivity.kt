package com.example.myfirstapplication2

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

const val EXTRA_MESSAGE = "com.example.myfirstapplication2.MESSAGE"

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val diceroll = Random().nextInt(6) + 1
        resultText.text = diceroll.toString()
        val diceImageChosen = when (diceroll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceImageChosen)

    }

    //Called when a button is pressed
    fun sendMessage (view: View){
        //do something in response to the button
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)


        }
        startActivity(intent)
    }
}
