package sk.mamrakm.coffeemachine.error.responses

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

class MachineNotFoundData {
    @ResponseBody
    @ExceptionHandler(MachineNotFound::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun employeeNotFoundHandler(e: MachineNotFound): String? {
        return e.message
    }

}