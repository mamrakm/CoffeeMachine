package sk.mamrakm.coffeemachine

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sk.mamrakm.coffeemachine.repository.interfaces.CaffeineConsumerTable
import sk.mamrakm.coffeemachine.repository.interfaces.MachineTable

@Configuration
class DataRepository {
    val log: Logger = LoggerFactory.getLogger(DataRepository::class.java)

    @Bean
    fun initMachineDatabase(MachineTable: MachineTable): CommandLineRunner {
        return CommandLineRunner {
            log.info("INIT: [Machines table]")
        }
    }

    @Bean
    fun initCoffeeDrinkersDatabase(drinkersRepository: CaffeineConsumerTable): CommandLineRunner {
        return CommandLineRunner {
            log.info("INIT: [Coffee drinkers table]")
        }
    }
}