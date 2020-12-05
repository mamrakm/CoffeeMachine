package sk.mamrakm.coffeemachine

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import sk.mamrakm.coffeemachine.error.responses.UserNotFound
import sk.mamrakm.coffeemachine.machines.Machine
import sk.mamrakm.coffeemachine.repository.interfaces.CaffeineConsumerTable
import sk.mamrakm.coffeemachine.repository.interfaces.MachineTable
import sk.mamrakm.coffeemachine.stats.Stats
import sk.mamrakm.coffeemachine.users.CoffeeDrinker

@RestController
class RestController(val coffeeConsumers: CaffeineConsumerTable, val machines: MachineTable, val stats: Stats) {

    @GetMapping("/machine")
    fun getAllMachines(): MutableList<Machine> {
        return machines.findAll()
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
        val user = coffeeConsumers.findById(userId).orElseThrow { UserNotFound(userId) }
        val machine = machines.findById(machineId).orElseThrow { UserNotFound(machineId) }
    }

    @PutMapping("/coffee/buy/{user-id}/{machine}")
    fun buyCoffeeFromMachineAtTime() {

    }

    @GetMapping("/stats/coffee")
    fun getCoffeeStats() {

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