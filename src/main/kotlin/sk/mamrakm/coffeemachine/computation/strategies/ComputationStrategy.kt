package sk.mamrakm.coffeemachine.computation.strategies

import java.time.LocalDateTime

interface ComputationStrategy {
    fun compute(
        ingestedAmountAtLastIngestionTime: Double,
        amountAlreadyPresentAtIngestionTime: Double,
        timeOfLastIngestion: LocalDateTime,
    ): Double
}