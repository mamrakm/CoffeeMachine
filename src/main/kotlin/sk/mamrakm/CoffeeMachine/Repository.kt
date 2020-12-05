package sk.mamrakm.CoffeeMachine

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sk.mamrakm.CoffeeMachine.Repositories.UserRepository
import sk.mamrakm.CoffeeMachine.Users.CaffeineUser

@Configuration
class Repository {
    val log: Logger = LoggerFactory.getLogger(Repository::class.java)

    @Bean
    fun initDatabase(repository: UserRepository): CommandLineRunner {
        return CommandLineRunner {
            log.info("Preloading ${repository.save(CaffeineUser("Jebko","password1", "jebko@kokotko.com"))}")
            log.info("Preloading ${repository.save(CaffeineUser("Moshe","password88", "moshe@kokotko.com"))}")
            log.info(repository.findById(1).get().id.toString())
            log.info(repository.findById(2).get().id.toString())
        }
    }
}