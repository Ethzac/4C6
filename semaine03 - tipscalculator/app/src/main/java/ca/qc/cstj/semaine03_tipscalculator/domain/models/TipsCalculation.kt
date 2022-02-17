package ca.qc.cstj.semaine03_tipscalculator.domain.models

import ca.qc.cstj.semaine03_tipscalculator.core.Constants

data class TipsCalculation(private val subtotal:Double, private val tipsPercent: Float) {

    val tipsAmount: Double = subtotal * tipsPercent
    val TPS: Double = subtotal * Constants.TPS
    val TVQ: Double = subtotal * Constants.TVQ
    val total: Double = subtotal + tipsAmount + TPS + TVQ

}