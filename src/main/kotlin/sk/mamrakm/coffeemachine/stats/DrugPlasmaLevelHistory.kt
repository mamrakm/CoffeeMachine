package sk.mamrakm.coffeemachine.stats

import sk.mamrakm.coffeemachine.computation.strategies.ComputationStrategy
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

class DrugPlasmaLevelHistory(
    coffeeDrinker: CoffeeDrinker,
    stats: StatOperations,
    val computationStrategy: ComputationStrategy
) {
    private val userHistory = stats.getUserTransactionHistory(coffeeDrinker.id)

    /**
     * I'm no expert in pharmacokinetics so this algorithm should be taken with a grain of salt.
     * The overall thought is that every ingestion of caffeine is added to the amount of already
     * present in blood. While last ingested amount is slowly reaching peak plasma concentration
     * in first hour the already present amount is slowly being cleaned from the body.
     */
    fun calculateWithOneHourGranularity(): MutableMap<Long, Double> {
        val mapHoursToCaffeineLevelsFromOldest = mutableMapOf<Long, Double>().withDefault { 0.0 }
        for (transaction in userHistory.sortedBy { it.dateTime }) {
            val caffeineFromMachine = transaction.machineUsed.caffeine
            val dateTimeOfCoffeeConsumption =
                transaction.dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()

            for (hour in 23L downTo 0L) {
                val computationTime = LocalDateTime.now().minus(hour, ChronoUnit.HOURS)
                if (dateTimeOfCoffeeConsumption.isBefore(computationTime)) {
                    mapHoursToCaffeineLevelsFromOldest[hour] =
                        mapHoursToCaffeineLevelsFromOldest.getValue(hour) + computationStrategy.compute(
                            mapHoursToCaffeineLevelsFromOldest.getValue(hour),
                            caffeineFromMachine,
                            dateTimeOfCoffeeConsumption,
                            computationTime
                        )
                }
            }
        }
        return mapHoursToCaffeineLevelsFromOldest
    }
}