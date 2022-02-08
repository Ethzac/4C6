package ca.qc.cstj.premiereapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //findViewById = document.getElementById()
        val btnMessage = findViewById<Button>(R.id.btnMessage)

        btnMessage.setOnClickListener {
            Toast.makeText( this, "bonjour", Toast.LENGTH_LONG).show()
        }

        val btnTelephoner = findViewById<Button>(R.id.btnTelephoner)

        btnTelephoner.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:450-123-4567"))
            startActivity(phoneIntent)
        }

        val btnSMS = findViewById<Button>(R.id.btnSMS)
        val edtNom = findViewById<EditText>(R.id.edtNom)

        btnSMS.setOnClickListener {
            val nom = edtNom.text.toString()
            val smsIntent = Intent(Intent.ACTION_VIEW, Uri.parse("smsto:450-123-4567"))
            smsIntent.putExtra("sms_body", "Bojour de $nom")
            startActivity(smsIntent)
        }

        val btnJeu = findViewById<Button>(R.id.btnJeu)

        btnJeu.setOnClickListener {
            val secondActivityIntent = SecondActivity.newIntent(this, edtNom.text.toString())
            startActivity(secondActivityIntent)
        }

    }
}