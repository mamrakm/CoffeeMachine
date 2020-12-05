package sk.mamrakm.coffeemachine.repository.interfaces

import sk.mamrakm.coffeemachine.machines.Machine
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.time.LocalDateTime

interface StatOperations {
    fun getCurrentPlasmaLevelForDrinkerWithId(id: Long)
    fun addDrinker(coffeeDrinker: CoffeeDrinker, machineUsed: Machine, milligrams: Int, dateTime: LocalDateTime)
    fun addDrinker(statsData: StatsData)
}