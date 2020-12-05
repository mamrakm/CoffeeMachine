package sk.mamrakm.coffeemachine.stats

import sk.mamrakm.coffeemachine.repository.interfaces.ComputationStrategy
import sk.mamrakm.coffeemachine.repository.interfaces.StatOperations
import java.time.ZoneId

class DrugPlasmaLevelHistory(userId: Long, stats: StatOperations, val computationStrategy: ComputationStrategy) {
    private val userHistory = stats.getUserTransactionHistory(userId)
    fun calculation() {
        var overallCaffeineAmmount = 0.0
        for (transaction in userHistory) {
            val caffeineFromMachine = transaction.machineUsed.caffeine
            val localDateTimeOfComsumption =
                transaction.dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
            overallCaffeineAmmount += computationStrategy.compute(overallCaffeineAmmount, caffeineFromMachine, localDateTimeOfComsumption)
        }
    }
}