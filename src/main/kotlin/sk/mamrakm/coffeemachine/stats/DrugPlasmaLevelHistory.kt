package sk.mamrakm.coffeemachine.stats

import sk.mamrakm.coffeemachine.computation.strategies.ComputationStrategy
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.time.ZoneId

class DrugPlasmaLevelHistory(coffeeDrinker: CoffeeDrinker, stats: StatOperations, val computationStrategy: ComputationStrategy) {
    private val userHistory = stats.getUserTransactionHistory(coffeeDrinker.id)
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