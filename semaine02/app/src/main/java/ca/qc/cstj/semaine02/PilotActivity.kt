package ca.qc.cstj.semaine02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.qc.cstj.semaine02.databinding.ActivityPilotBinding
import ca.qc.cstj.semaine02.domain.models.Pilot

class PilotActivity : AppCompatActivity() {

    //permet d'accéder aux composants graphiques de l'interface
    private lateinit var binding: ActivityPilotBinding

    private val _pilot = Pilot("Timothé", 10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Charge le visuel dans l'objet binding
        binding = ActivityPilotBinding.inflate(layoutInflater)

        setContentView(binding.root)

        refreshUI()

        binding.btnStart.setOnClickListener {
            if(_pilot.canFly()) {
                _pilot.fly(binding.sldRev.value.toInt(), binding.swcTraining.isChecked)

                refreshUI()
            }
        }
    }

    private fun refreshUI() {

        with(binding) {
            txtName.text = _pilot.name
            txtLevel.text = "Level: " + _pilot.level.toString()
            nbCube.text = _pilot.cube.toString()
            nbEnergy.text = _pilot.energy.toString()
            nbShield.text = _pilot.shield.toString()
            nbLife.text = _pilot.life.toString()
        }
    }
}