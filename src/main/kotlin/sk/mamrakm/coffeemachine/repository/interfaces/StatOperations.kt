package sk.mamrakm.coffeemachine.repository.interfaces

import sk.mamrakm.coffeemachine.machines.Machine
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.util.*

interface StatOperations {
    fun addDrinker(coffeeDrinker: CoffeeDrinker, machineUsed: Machine, milligrams: Int, dateTime: Date)
    fun addDrinker(statsData: StatsData)
    fun getAllDrinkers(): MutableList<StatsData>

    fun getDrinkerData(id: Long): List<StatsData>
    fun getMachineData(id: Long): List<StatsData>
}