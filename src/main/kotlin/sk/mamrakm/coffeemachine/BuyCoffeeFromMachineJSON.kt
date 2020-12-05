package sk.mamrakm.coffeemachine

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class BuyCoffeeFromMachineJSON(@JsonFormat val timestamp: Date)
