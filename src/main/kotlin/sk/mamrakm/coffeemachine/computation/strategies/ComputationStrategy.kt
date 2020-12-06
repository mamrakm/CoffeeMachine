package sk.mamrakm.coffeemachine.computation.strategies

import java.time.LocalDateTime

interface ComputationStrategy {
    fun compute(
        amountAlreadyPresentAtIngestionTime: Double,
        ingestedAmountAtLastIngestionTime: Double,
        timeOfLastIngestion: LocalDateTime,
    ): Double
}