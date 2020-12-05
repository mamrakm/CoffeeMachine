package sk.mamrakm.CoffeeMachine

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import sk.mamrakm.CoffeeMachine.Machines.Machine
import sk.mamrakm.CoffeeMachine.RepositoryInterfaces.MachineRepository
import sk.mamrakm.CoffeeMachine.RepositoryInterfaces.UserRepository
import sk.mamrakm.CoffeeMachine.Users.CaffeineUser

@RestController
class RestController(val userRepository: UserRepository, val machineRepository: MachineRepository) {

    @PutMapping("/user/request")
    fun saveUser(@RequestBody user: CaffeineUser) {
        println("${user.login} ${user.email} ${user.password}")
        userRepository.save(user)
    }

    @PostMapping("/machine")
    fun registerMachine(@RequestBody machineData: Machine) {
        machineRepository.save(machineData)
    }
    
    @GetMapping("/coffee/buy/{user-id}/{machine-id}")
    fun registerCoffeeBoughtByUser(
        @PathVariable("user-id") userId: String,
        @PathVariable("machine-id") machineId: String
    ) {

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