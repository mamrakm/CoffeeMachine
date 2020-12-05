package sk.mamrakm.coffeemachine.repository.interfaces

import org.springframework.data.jpa.repository.JpaRepository
import sk.mamrakm.coffeemachine.users.CoffeeDrinker

interface CaffeineConsumerTable : JpaRepository<CoffeeDrinker, Long>