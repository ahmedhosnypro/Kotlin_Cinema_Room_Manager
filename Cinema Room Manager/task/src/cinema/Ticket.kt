package cinema

import java.util.*

object Ticket {
    private fun ticketPrice(row: Int, room: Room): Int {
        val price: Int = if (room.rows * room.seats <= 60) {
            10
        } else {
            val frontHalf = room.rows / 2
            if (row <= frontHalf) {
                10
            } else {
                8
            }
        }
        return price
    }

    fun reserveTicket(room: Room) {
        val scanner = Scanner(System.`in`)
        println("Enter a row number:")
        val row = scanner.nextInt()
        println("Enter a seat number in that row:")
        val seat = scanner.nextInt()
        if (row > room.rows || seat > room.seats) {
            println("\nWrong input!")
            reserveTicket(room)
        } else {
            if (room.getRoom()[row][seat] == "B") {
                println("\nThat ticket has already been purchased!")
                reserveTicket(room)
            } else {
                val price = ticketPrice(row, room)
                println("\nTicket price: $$price")
                room.reserveSeat(row, seat)
            }
        }
    }
}