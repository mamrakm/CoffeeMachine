package sk.mamrakm.coffeemachine.repository.interfaces

import org.springframework.data.jpa.repository.JpaRepository
import sk.mamrakm.coffeemachine.machines.Machine

interface MachineTable : JpaRepository<Machine, Long> {
}