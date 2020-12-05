package sk.mamrakm.coffeemachine.stats

import org.springframework.stereotype.Component
import sk.mamrakm.coffeemachine.machines.Machine
import sk.mamrakm.coffeemachine.repository.interfaces.StatOperations
import sk.mamrakm.coffeemachine.repository.interfaces.StatsData
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.time.LocalDateTime

@Component
class Stats : StatOperations {
    private val dataList: MutableList<StatsData> by lazy { arrayListOf() }

    override fun getCurrentPlasmaLevelForDrinkerWithId(id: Long) {
        TODO("Not yet implemented")
    }

    override fun addDrinker(
        coffeeDrinker: CoffeeDrinker,
        machineUsed: Machine,
        milligrams: Int,
        dateTime: LocalDateTime
    ) {
        dataList.add(StatsData(coffeeDrinker, machineUsed, milligrams, dateTime))
    }

    override fun addDrinker(drinkerData: StatsData) {
        dataList.add(drinkerData)
    }
}