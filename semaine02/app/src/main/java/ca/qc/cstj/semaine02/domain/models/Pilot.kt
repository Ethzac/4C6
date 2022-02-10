package ca.qc.cstj.semaine02.domain.models

import kotlin.random.Random

data class Pilot(var name: String, var life: Int, var cube: Int = 0) {

    private var _experience: Int = 0
    val level: Int get() = _experience / 10
    var shield: Int = 10
    var energy: Int = 10

    fun fly(revolutions: Int, isTraining: Boolean) {

        if(!isTraining) {
            _experience += revolutions * Random.nextInt(1, 6)
            life -= Random.nextInt(0, 2)
            shield -= Random.nextInt(0, 2)
            energy -= 1

        }
    }

    fun canFly() : Boolean {
        return life > 0 && energy > 0
    }

    fun recharge() {
        energy = 10
    }
}