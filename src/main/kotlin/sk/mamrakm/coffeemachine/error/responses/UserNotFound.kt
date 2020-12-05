package sk.mamrakm.coffeemachine.error.responses

class UserNotFound(id: Long) : RuntimeException("User with id:${id} not found")