package sk.mamrakm.CoffeeMachine

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import sk.mamrakm.CoffeeMachine.Machines.Machine
import sk.mamrakm.CoffeeMachine.Repositories.UserRepository
import sk.mamrakm.CoffeeMachine.Users.CaffeineUser

@RestController
class RestController(val repository: UserRepository) {

    @GetMapping("/users")
    fun all() : List<CaffeineUser> {
        return repository.findAll()
    }

    @PutMapping("/user/request")
    fun saveUser(@RequestBody user : CaffeineUser) {
        println("${user.login} ${user.email} ${user.password}")
        repository.save(user)
    }

    @PostMapping("/user/request")
    fun saveMachine(@RequestBody machine : Machine) {
    }

    @GetMapping("/coffee/buy/{user-id}/{machine-id}")
    fun registerCoffeeBoughtByUser(@PathVariable("user-id") userId : String, @PathVariable("machine-id") machineId : String) {

    }
}