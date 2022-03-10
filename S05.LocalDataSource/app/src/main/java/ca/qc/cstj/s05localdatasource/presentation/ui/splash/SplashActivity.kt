package ca.qc.cstj.s05localdatasource.presentation.ui.splash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.core.loadFromResource
import ca.qc.cstj.s05localdatasource.databinding.ActivitySplashBinding
import ca.qc.cstj.s05localdatasource.presentation.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel.user.observe(this) {

            binding.tilFirstName.editText!!.setText(it.firstName)
            binding.tilLastName.editText!!.setText(it.lastName)
            binding.swtOnline.isChecked = it.isOnline

            binding.txvUserName.text = it.fullName

            if(it.isOnline) {
                binding.imgUserIsOnline.setImageResource(R.drawable.online)
            } else {
                binding.imgUserIsOnline.setImageResource(R.drawable.offline)
            }
        }

        binding.btnSave.setOnClickListener {

            val firstName = binding.tilFirstName.editText!!.text.toString()
            val lastName = binding.tilLastName.editText!!.text.toString()
            val isOnline = binding.swtOnline.isChecked

            viewModel.save(firstName, lastName, isOnline)
        }

        binding.btnOpen.setOnClickListener {

            startActivity(MainActivity.newIntent(this))
        }
    }
}