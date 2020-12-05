package sk.mamrakm.coffeemachine.stats

interface StatOperations {
    fun addDrinker(statsData: StatsData)

    fun getMachineTransactionHistory(id: Long): List<StatsData>
    fun getUserTransactionHistory(id: Long): List<StatsData>
    fun getAllTransactionHistory() : List<StatsData>
}