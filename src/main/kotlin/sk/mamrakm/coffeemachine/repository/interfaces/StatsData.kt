package sk.mamrakm.coffeemachine.repository.interfaces

import sk.mamrakm.coffeemachine.machines.Machine
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.util.*

data class StatsData(
    val coffeeDrinker: CoffeeDrinker,
    val machineUsed: Machine,
    val milligrams: Int,
    val dateTime: Date
)
