package ca.qc.cstj.semaine02.presentation.ui.pilot

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import ca.qc.cstj.semaine02.R
import ca.qc.cstj.semaine02.databinding.ActivityPilotBinding
import ca.qc.cstj.semaine02.domain.models.Pilot
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

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
                binding.btnStart.isEnabled = false
                _pilot.fly(binding.sldRev.value.toInt(), binding.swcTraining.isChecked)

                val layoutParams = binding.imvRocket.layoutParams as ConstraintLayout.LayoutParams
                val startAngle = layoutParams.circleAngle
                val endAngle = startAngle - 360
                val animation = ValueAnimator.ofFloat(startAngle, endAngle)

                animation.repeatCount = binding.sldRev.value.toInt() - 1
                animation.duration = Random.nextLong(500, 2500)
                animation.interpolator = AccelerateDecelerateInterpolator()

                animation.addUpdateListener {
                    val layoutParamsAnimation = binding.imvRocket.layoutParams as ConstraintLayout.LayoutParams
                    val animatedValue = it.animatedValue as Float
                    layoutParamsAnimation.circleAngle = animatedValue
                    binding.imvRocket.layoutParams = layoutParamsAnimation
                    binding.imvRocket.rotation = (animatedValue - 90) * 3
                    Log.d("Yannick", animatedValue.toString())
                }

                animation.doOnEnd {
                    binding.btnStart.isEnabled = true
                    refreshUI()
                }

                animation.start()

            } else {
                Snackbar.make(binding.root, getString(R.string.lowResource), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.recharge)) {
                        _pilot.recharge()
                        refreshUI()
                    }
                    .show()
            }
        }
    }

    private fun refreshUI() {

        with(binding) {
            txtName.text = _pilot.name
            txtLevel.text = getString(R.string.level, _pilot.level)
            nbCube.text = _pilot.cube.toString()
            nbEnergy.text = _pilot.energy.toString()
            nbShield.text = _pilot.shield.toString()
            nbLife.text = _pilot.life.toString()
        }
    }
}

/*

import androidx.lifecyle.LiveData
import androidx.lifecyle.MutableLiveData
import androidx.lifecyle.ViewModel
import ca.qc.cstj.s02constraintlayout.domain.models.pilot

class PilotViewModel : ViewModel() {



}

 */