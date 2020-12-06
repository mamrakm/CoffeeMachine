package sk.mamrakm.coffeemachine.stats

import sk.mamrakm.coffeemachine.computation.strategies.ComputationStrategy
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.time.ZoneId

class DrugPlasmaLevelHistory(coffeeDrinker: CoffeeDrinker, stats: StatOperations, val computationStrategy: ComputationStrategy) {
    private val userHistory = stats.getUserTransactionHistory(coffeeDrinker.id)

    /**
     * I'm no expert in pharmacokinetics so this algorithm should be taken with a grain of salt.
     * The overall thought is that every ingestion of caffeine is added to the amount of already
     * present in blood. While last ingested amount is slowly reaching peak plasma concentration
     * in first hour the already present amount is slowly being cleaned from the body.
     */
    fun calculation(): Double {
        var overallCaffeineAmmount = 0.0
        for (transaction in userHistory) {
            val caffeineFromMachine = transaction.machineUsed.caffeine
            val localDateTimeOfComsumption =
                transaction.dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
            overallCaffeineAmmount += computationStrategy.compute(overallCaffeineAmmount, caffeineFromMachine, localDateTimeOfComsumption)
        }
        return overallCaffeineAmmount
    }
}