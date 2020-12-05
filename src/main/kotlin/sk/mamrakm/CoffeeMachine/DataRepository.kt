package sk.mamrakm.CoffeeMachine

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sk.mamrakm.CoffeeMachine.RepositoryInterfaces.MachineRepository
import sk.mamrakm.CoffeeMachine.RepositoryInterfaces.UserRepository

@Configuration
class DataRepository {
    val log: Logger = LoggerFactory.getLogger(UserRepository::class.java)

    @Bean
    fun initUserDatabase(userRepository: UserRepository): CommandLineRunner {
        return CommandLineRunner {
            log.info("INIT: [Caffeine users repository]")
        }
    }

    @Bean
    fun initMachineDatabase(MachineRepository: MachineRepository): CommandLineRunner {
        return CommandLineRunner {
            log.info("INIT: [Machines repository]")
        }
    }
}