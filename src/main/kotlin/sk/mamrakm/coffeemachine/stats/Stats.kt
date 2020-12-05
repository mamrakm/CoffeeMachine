package sk.mamrakm.coffeemachine.stats

import org.springframework.stereotype.Component
import sk.mamrakm.coffeemachine.repository.interfaces.StatOperations
import sk.mamrakm.coffeemachine.users.CoffeeDrinker
import java.util.*

@Component
class Stats : StatOperations {
    override fun getCurrentPlasmaLevelForDrinkerWithId(id: Long) {
        TODO("Not yet implemented")
    }

    override fun addDrinker(coffeeDrinker: CoffeeDrinker, milligrams: Int, dateTime: Date) {
        TODO("Not yet implemented")
    }
}