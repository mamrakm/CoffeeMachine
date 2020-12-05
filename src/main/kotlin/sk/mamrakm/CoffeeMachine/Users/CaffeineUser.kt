package sk.mamrakm.CoffeeMachine.Users

import sk.mamrakm.CoffeeMachine.CaffeinePlasmaValue
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class CaffeineUser(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) val id: Long? = null,
    val login: String,
    val password: String,
    val email: String,
) : CaffeinePlasmaValue {
    private var caffeinePlasmaLevel: Int? = null
    override fun getCaffeineCurrentPlasmaValue() {
    }
}
