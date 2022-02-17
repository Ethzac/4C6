package ca.qc.cstj.semaine03_tipscalculator.presentation.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ca.qc.cstj.semaine03_tipscalculator.R

import ca.qc.cstj.semaine03_tipscalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Charger le visual
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {

            val subtotal = binding.tilSubtotal.editText!!.text.toString().toDouble()
            val tips = binding.tilTips.editText!!.text.toString().toFloat()

            viewModel.calculate(subtotal, tips)
        }
    }

}