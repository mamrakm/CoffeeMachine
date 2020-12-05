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
    }

    @PostMapping("/user/request")
    fun saveMachine(@RequestBody machine : Machine) {
    }
}