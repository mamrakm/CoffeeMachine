package sk.mamrakm.CoffeeMachine.Repositories

import org.springframework.data.jpa.repository.JpaRepository
import sk.mamrakm.CoffeeMachine.Users.CaffeineUser

interface UserRepository : JpaRepository<CaffeineUser, Long> {
}