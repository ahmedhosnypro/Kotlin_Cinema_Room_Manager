package cinema

import cinema.Statistics.showStatistics
import cinema.Ticket.reserveTicket
import java.util.*

object Action {
    fun selectAction(room: Room): Boolean {
        var isContinue = true
        val scanner = Scanner(System.`in`)
        println(
            """
                
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """.trimIndent()
        )
        when (scanner.nextInt()) {
            1 -> print(room)
            2 -> reserveTicket(room)
            3 -> showStatistics(room)
            0 -> isContinue = false
        }
        return isContinue
    }
}