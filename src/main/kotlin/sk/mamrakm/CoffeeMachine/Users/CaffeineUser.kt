package sk.mamrakm.CoffeeMachine.Users

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class CaffeineUser(
    val login : String,
    val password : String,
    val email : String,) {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id : Long? = null
}