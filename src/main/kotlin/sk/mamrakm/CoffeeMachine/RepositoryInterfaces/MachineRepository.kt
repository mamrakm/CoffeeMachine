package sk.mamrakm.CoffeeMachine.RepositoryInterfaces

import org.springframework.data.jpa.repository.JpaRepository
import sk.mamrakm.CoffeeMachine.Machines.Machine

interface MachineRepository : JpaRepository<Machine, Long> {
}