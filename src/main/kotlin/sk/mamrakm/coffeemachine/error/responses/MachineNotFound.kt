package sk.mamrakm.coffeemachine.error.responses

class MachineNotFound(id: Long) : RuntimeException("User with id:${id} not found")