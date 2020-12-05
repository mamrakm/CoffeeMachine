package sk.mamrakm.coffeemachine.users

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class CoffeeDrinker(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    val login: String,
    val password: String,
    val email: String,
    @JsonIgnore var caffeinePlasmaLevel: Int,
)