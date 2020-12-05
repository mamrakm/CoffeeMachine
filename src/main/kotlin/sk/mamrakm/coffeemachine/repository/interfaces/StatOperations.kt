package sk.mamrakm.coffeemachine.repository.interfaces

import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.util.*

interface StatOperations {
    fun getCurrentPlasmaLevelForDrinkerWithId(id: Long)
    fun addDrinker(coffeeDrinker: CoffeeDrinker, milligrams: Int, dateTime: Date)
}