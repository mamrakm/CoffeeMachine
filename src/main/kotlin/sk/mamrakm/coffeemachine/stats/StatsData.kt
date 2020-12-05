package sk.mamrakm.coffeemachine.stats

import sk.mamrakm.coffeemachine.machines.Machine
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.util.*

data class StatsData(
    val coffeeDrinker: CoffeeDrinker,
    val machineUsed: Machine,
    val milligrams: Double,
    val dateTime: Date
)
