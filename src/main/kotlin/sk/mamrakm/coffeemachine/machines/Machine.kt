package sk.mamrakm.coffeemachine.machines

import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import javax.persistence.*

@Entity
data class Machine(@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) val id: Long, val name: String, val caffeine: Int) {
    @OneToMany
    val machineUsers: MutableList<CoffeeDrinker> = arrayListOf()
}
