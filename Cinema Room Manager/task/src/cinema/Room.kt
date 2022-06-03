package cinema

import java.util.*

class Room internal constructor() {
    private var room: Array<Array<String?>>
    var rows: Int
    var seats: Int

    init {
        val scanner = Scanner(System.`in`)
        println("Enter the number of rows:")
        val rows = scanner.nextInt()
        println("Enter the number of seats in each row:")
        val seats = scanner.nextInt()
        this.rows = rows
        this.seats = seats
        room = Array(rows + 1) { arrayOfNulls(seats + 1) }
        for (i in 0 until rows + 1) {
            for (j in 0 until seats + 1) {
                if (i == 0 && j == 0) {
                    room[i][j] = " "
                } else if (i == 0) {
                    room[i][j] = j.toString()
                } else if (j == 0) {
                    room[i][j] = i.toString()
                } else room[i][j] = "S"
            }
        }
    }

    override fun toString(): String {
        val ret = StringBuilder("Cinema:\n")
        for (strings in room) {
            for (j in strings.indices) {
                if (j == room.size) {
                    ret.append(strings[j])
                } else {
                    ret.append(strings[j] + " ")
                }
            }
            ret.append("\n")
        }
        return ret.toString()
    }

    fun reserveSeat(row: Int, seat: Int) {
        room[row][seat] = "B"
    }
}