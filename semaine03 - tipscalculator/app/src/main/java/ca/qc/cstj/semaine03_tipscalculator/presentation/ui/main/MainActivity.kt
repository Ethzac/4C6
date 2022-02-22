package ca.qc.cstj.semaine03_tipscalculator.presentation.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import ca.qc.cstj.semaine03_tipscalculator.R
import ca.qc.cstj.semaine03_tipscalculator.core.Formatter

import ca.qc.cstj.semaine03_tipscalculator.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Charger le visual
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {


            try {

                val subtotal = binding.tilSubtotal.editText!!.text.toString().toDouble()
                val tips = binding.tilTips.editText!!.text.toString().toFloat()
                viewModel.calculate(subtotal, tips)

            } catch(ex: NumberFormatException) {
                Toast.makeText(this, "LoL's chat", Toast.LENGTH_LONG).show()
            }


        }

        viewModel.tipsCalculation.observe(this) {
            binding.lblTips.text = Formatter.toMoneyFormat(it.tipsAmount)
            binding.lblTPS.text = Formatter.toMoneyFormat(it.TPS)
            binding.lblTVQ.text = Formatter.toMoneyFormat(it.TVQ)
            binding.lblTotal.text = Formatter.toMoneyFormat(it.total)
        }
    }

}