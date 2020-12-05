package sk.mamrakm.coffeemachine.stats

import org.springframework.stereotype.Component
import sk.mamrakm.coffeemachine.repository.interfaces.StatOperations
import sk.mamrakm.coffeemachine.repository.interfaces.StatsData

@Component
class Stats : StatOperations {
    private val dataList: MutableList<StatsData> = arrayListOf()

    override fun addDrinker(drinkerData: StatsData) {
        dataList.add(drinkerData)
    }

    override fun getMachineTransactionHistory(id: Long): List<StatsData> {
        return dataList.filter { it.machineUsed.id == id }
    }

    override fun getUserTransactionHistory(id: Long): List<StatsData> {
        return dataList.filter { it.coffeeDrinker.id == id }
    }

    override fun getAllTransactionHistory(): List<StatsData> {
        return dataList
    }
}