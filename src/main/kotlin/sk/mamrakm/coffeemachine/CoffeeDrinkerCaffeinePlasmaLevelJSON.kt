package sk.mamrakm.coffeemachine

import sk.mamrakm.coffeemachine.users.CoffeeDrinker

data class CoffeeDrinkerCaffeinePlasmaLevelJSON(val coffeeDrinker: CoffeeDrinker, val levels: Map<Long, Double>)