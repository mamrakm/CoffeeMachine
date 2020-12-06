package sk.mamrakm.coffeemachine.computation.strategies

import java.lang.RuntimeException
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class CaffeinePlasmaLevelComputationStrategy : ComputationStrategy {
    override fun compute(
        amountAlreadyPresentAtIngestionTime: Double,
        ingestedAmountAtLastIngestionTime: Double,
        timeOfIngestion: LocalDateTime,
        timeOfComputation: LocalDateTime
    ): Double {
        val minutesElapsed = timeOfIngestion.until(timeOfComputation, ChronoUnit.MINUTES)
        val hoursElapsed = timeOfIngestion.until(timeOfComputation, ChronoUnit.HOURS)

        if (minutesElapsed < 0
            || hoursElapsed < 0) {
            throw RuntimeException("Invalid date value")
        }
        var halfLifes = 0
        if (minutesElapsed < 60) {
            return amountAlreadyPresentAtIngestionTime + (ingestedAmountAtLastIngestionTime * (minutesElapsed.toDouble()/60.0))
        } else {
            for(hour in 1..hoursElapsed) {
                if (hour % 5 == 0L) {
                    halfLifes++
                }
            }
            return (amountAlreadyPresentAtIngestionTime + ingestedAmountAtLastIngestionTime) * Math.pow(0.5, halfLifes.toDouble())
        }
    }
}