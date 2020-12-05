package sk.mamrakm.coffeemachine.repository.interfaces

import sk.mamrakm.coffeemachine.machines.Machine
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.time.LocalDateTime

data class StatsData(
    val coffeeDrinker: CoffeeDrinker,
    val machineUsed: Machine,
    val milligrams: Int,
    val dateTime: LocalDateTime
)
