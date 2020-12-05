package sk.mamrakm.CoffeeMachine.Machines

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Machine(@Id @GeneratedValue val id: Long? = null, val name: String, val caffeine: Int)