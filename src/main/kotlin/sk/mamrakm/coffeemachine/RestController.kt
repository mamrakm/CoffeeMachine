package sk.mamrakm.coffeemachine

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import sk.mamrakm.coffeemachine.error.responses.DrinkerNotFound
import sk.mamrakm.coffeemachine.machines.Machine
import sk.mamrakm.coffeemachine.repository.interfaces.CaffeineConsumerTable
import sk.mamrakm.coffeemachine.repository.interfaces.MachineTable
import sk.mamrakm.coffeemachine.repository.interfaces.StatOperations
import sk.mamrakm.coffeemachine.repository.interfaces.StatsData
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

@RestController
class RestController(
    val coffeeConsumers: CaffeineConsumerTable,
    val machines: MachineTable,
    val stats: StatOperations
) {

    @GetMapping("/machine")
    fun getAllMachines(): MutableList<Machine> {
        return machines.findAll()
    }

    @GetMapping("/user")
    fun getAllUsers(): MutableList<CoffeeDrinker> {
        return coffeeConsumers.findAll()
    }

    @PutMapping("/user/request")
    fun saveUser(@RequestBody user: CoffeeDrinker): Long {
        return coffeeConsumers.save(user).id
    }

    @PostMapping("/machine")
    fun registerMachine(@RequestBody machineData: Machine): Long {
        return machines.save(machineData).id
    }

    @GetMapping("/coffee/buy/{user-id}/{machine-id}")
    fun registerCoffeeBoughtByUserCurrentTime(
        @PathVariable("user-id") userId: Long,
        @PathVariable("machine-id") machineId: Long
    ) {
        val drinker = coffeeConsumers.findById(userId).orElseThrow { DrinkerNotFound(userId) }
        val machine = machines.findById(machineId).orElseThrow { DrinkerNotFound(machineId) }

        val dateTime = LocalDateTime.now()
        dateTime.format(DateTimeFormatter.ISO_DATE_TIME)
        stats.addDrinker(
            StatsData(
                drinker,
                machine,
                machine.caffeine,
                Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant())
            )
        )
    }

    @PutMapping("/coffee/buy/{user-id}/{machine}")
    fun buyCoffeeFromMachineAtTime(
        @RequestBody buyCoffeeFromMachine: BuyCoffeeFromMachineJSON,
        @PathVariable("user-id") userId: Long,
        @PathVariable("machine") machineId: Long
    ) {
        val drinker = coffeeConsumers.findById(userId).orElseThrow { DrinkerNotFound(userId) }
        val machine = machines.findById(machineId).orElseThrow { DrinkerNotFound(machineId) }
        stats.addDrinker(StatsData(drinker, machine, machine.caffeine, buyCoffeeFromMachine.timestamp as Date))
    }

    @GetMapping("/stats/coffee")
    fun getCoffeeStats(): MutableList<StatsData> {
        return stats.getAllDrinkers()
    }

    @GetMapping("/stats/coffee/machine/{id}")
    fun getCoffeeStatsForMachineWithId(@PathVariable("id") id: Int) {

    }

    @GetMapping("/stats/coffee/user/{id}")
    fun getCoffeeStatsForUserWithId(@PathVariable("id") id: Int) {

    }

    @GetMapping("/stats/level/user/{id}")
    fun getCaffeineStatsInPast24HourForUser(@PathVariable("id") id: Int) {

    }
}