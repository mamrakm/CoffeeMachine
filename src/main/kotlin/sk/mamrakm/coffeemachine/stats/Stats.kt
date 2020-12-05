package sk.mamrakm.coffeemachine.stats

import org.springframework.stereotype.Component
import sk.mamrakm.coffeemachine.machines.Machine
import sk.mamrakm.coffeemachine.repository.interfaces.StatOperations
import sk.mamrakm.coffeemachine.repository.interfaces.StatsData
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.util.*

@Component
class Stats : StatOperations {
    private val dataList: MutableList<StatsData> = arrayListOf()

    override fun addDrinker(
        coffeeDrinker: CoffeeDrinker,
        machineUsed: Machine,
        milligrams: Int,
        dateTime: Date
    ) {
        dataList.add(StatsData(coffeeDrinker, machineUsed, milligrams, dateTime))
    }

    override fun addDrinker(drinkerData: StatsData) {
        dataList.add(drinkerData)
    }

    override fun getAllDrinkers(): MutableList<StatsData> {
        return dataList
    }

    override fun getDrinkerData(id: Long): List<StatsData> {
        return dataList.filter { it.coffeeDrinker.id == id }
    }

    override fun getMachineData(id: Long): List<StatsData> {
        return dataList.filter { it.machineUsed.id == id }
    }
}