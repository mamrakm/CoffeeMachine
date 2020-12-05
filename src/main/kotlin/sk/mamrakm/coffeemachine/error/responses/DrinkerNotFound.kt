package sk.mamrakm.coffeemachine.error.responses

class DrinkerNotFound(id: Long) : RuntimeException("User with id:${id} not found")