package sk.mamrakm.coffeemachine

import sk.mamrakm.coffeemachine.repository.interfaces.ComputationStrategy
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class CaffeinePlasmaLevelComputationStrategy : ComputationStrategy {
    override fun compute(
        ingestedAmountAtLastIngestionTime: Double,
        amountAlreadyPresentAtIngestionTime: Double,
        timeOfLastIngestion: LocalDateTime,
    ): Double {
        val currentTime = LocalDateTime.now()
        val minutesElapsed = timeOfLastIngestion.until(currentTime, ChronoUnit.MINUTES)
        val hoursElapsed = timeOfLastIngestion.until(currentTime, ChronoUnit.HOURS)
        var halfLifes = 0
        if (minutesElapsed < 60) {
            return amountAlreadyPresentAtIngestionTime + (ingestedAmountAtLastIngestionTime * (minutesElapsed/60))
        } else {
            for(hour in 0..hoursElapsed) {
                if (hour % 5 == 0L) {
                    halfLifes++
                }
            }
            return amountAlreadyPresentAtIngestionTime + (ingestedAmountAtLastIngestionTime * Math.pow(0.5, halfLifes.toDouble()))
        }
    }
}