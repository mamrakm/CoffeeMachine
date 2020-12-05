package sk.mamrakm.coffeemachine.repository.interfaces

import java.time.LocalDateTime

interface ComputationStrategy {
    fun compute(
        ingestedAmountAtLastIngestionTime: Double,
        amountAlreadyPresentAtIngestionTime: Double,
        timeOfLastIngestion: LocalDateTime,
    ): Double
}