package cinema

import cinema.Action.selectAction

fun main() {
    val room = Room()

    var toContinue = true
    while (toContinue) {
        toContinue = selectAction(room)
    }
}
