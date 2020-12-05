package sk.mamrakm.coffeemachine.repository.interfaces

import java.time.LocalDateTime

interface DrugUser {
    fun getIngestedDrugAmountAtGivenTime(): Double

    companion object DrugUserUtils {
        fun calculateDrugCurrentPlasmaLevelAtTime(time: LocalDateTime): Double {
            return 0.0
        }
    }
}