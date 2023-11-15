package de.syntaxinstitut.liveappuserinput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //Layout wird geladen
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Lade Views aus dem Layout über die Id
        val inputET = findViewById<EditText>(R.id.inputET)
        val greetingTV = findViewById<TextView>(R.id.greetingTV)
        val hoeflichkeitSW = findViewById<Switch>(R.id.hoeflichkeitSW)
        val outputFAB = findViewById<FloatingActionButton>(R.id.outputFAB)

        //Erstelle einen OnClickListener -> Der Code in den geschweiften Klammern wird jedes mal
        //ausgeführt wenn man den Knopf drückt
        outputFAB.setOnClickListener {

            //Lade Inhalt aus dem Textfeld als String
            val name = inputET.text.toString()
            Log.d("InputTest1", name)

            //Lade Inhalt aus dem Switch als Boolean
            val hoeflichkeit: Boolean = hoeflichkeitSW.isChecked
            Log.d("InputTest2", hoeflichkeit.toString())

            //Leere das Eingabefeld
            inputET.setText("")


            //Greeting String definieren
            var greeting = ""

            //Greeting String mit sinnvollem Inhalt füllen
            if (hoeflichkeit) {
                greeting = getString(R.string.greeting_hoeflich, name)
            } else {
                greeting = getString(R.string.greeting_unhoeflich, name)
            }

            //Greeting in die TextView schreiben
            greetingTV.text = greeting

        }
    }

    fun login(password: String) {
        if (password == "password123") {
            Toast.makeText(this, "Du bist Mitglied der geheimen Programmierergesellschaft!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Falsches Passwort", Toast.LENGTH_LONG).show()
        }
    }
}


