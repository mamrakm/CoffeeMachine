package sk.mamrakm.coffeemachine.error.responses

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class UserNotFoundData() {
    @ResponseBody
    @ExceptionHandler(DrinkerNotFound::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun employeeNotFoundHandler(e: DrinkerNotFound): String? {
        return e.message
    }
}