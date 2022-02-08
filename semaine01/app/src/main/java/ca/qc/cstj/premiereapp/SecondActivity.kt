package ca.qc.cstj.premiereapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

const val MIN_NUMBER = 0;
const val MAX_NUMBER = 100;

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txvDeviner = findViewById<TextView>(R.id.txvDeviner)
        val btnVerifier = findViewById<Button>(R.id.btnVerifier)
        val nprNombre = findViewById<NumberPicker>(R.id.nprNombre)

        txvDeviner.text = getString(R.string.msgDevinerNombre, intent.getStringExtra(INTENT_EXTRA_NAME))

        nprNombre.minValue = MIN_NUMBER
        nprNombre.maxValue = MAX_NUMBER

        val theNumber = (MIN_NUMBER..MAX_NUMBER).random()

        btnVerifier.setOnClickListener {
            if (nprNombre.value == theNumber) {
                Toast.makeText(this, getString(R.string.msgWinner), Toast.LENGTH_LONG).show()
            } else if (nprNombre.value > theNumber) {
                Toast.makeText(this, getString(R.string.msgLesser), Toast.LENGTH_LONG).show()
            } else {
                //plus petit
                Toast.makeText(this, getString(R.string.msgHigher), Toast.LENGTH_LONG).show()
            }
        }
    }

    //companion statique de ma classe
    companion object {
        const val INTENT_EXTRA_NAME = "EXTRA_NAME"
        fun newIntent(context: Context, name:String): Intent {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            return intent
        }
    }

}