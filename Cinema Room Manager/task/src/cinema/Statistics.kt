package cinema

object Statistics {
    fun showStatistics(room: Room) {
        println()
        System.out.printf("Number of purchased tickets: %d\n", ticketsNumber(room))
        System.out.printf("Percentage: %.2f%%\n", ticketsPercentages(room))
        System.out.printf("Current income: $%d\n", currentIncome(room))
        System.out.printf("Total income: $%d\n", totalIncome(room))
    }

    private fun ticketsNumber(room: Room): Int {
        var count = 0
        for (i in 0 until room.rows + 1) {
            for (j in 0 until room.seats + 1) {

                if ((i != 0 && j != 0) && !room.getRoom()[i][j].equals("S")) {
                    count++
                }

            }
        }
        return count
    }

    private fun ticketsPercentages(room: Room): Double {
        val ticketsNumber = ticketsNumber(room).toDouble()
        var percentages = 0.0
        if (ticketsNumber > 0) {
            percentages = ticketsNumber / (room.rows * room.seats)
        }
        percentages *= 100.0
        return percentages
    }

    private fun currentIncome(room: Room): Int {
        var currentIncome = 0
        currentIncome += if (room.rows * room.seats <= 60) {
            backHalfIncome(room)
        } else {
            frontHalfIncome(room)
        }
        return currentIncome
    }


    private fun backHalfIncome(room: Room): Int {
        var currentIncome = 0
        for (i in 0 until room.rows + 1) {
            for (j in 0 until room.seats + 1) {
                if ((i != 0 && j != 0) && !room.getRoom()[i][j].equals("S")) {
                    currentIncome += 10
                }
            }
        }
        return currentIncome
    }

    private fun frontHalfIncome(room: Room): Int {
        var currentIncome = 0
        val frontHalf = room.rows / 2
        room.rows - frontHalf
        for (i in 0 until room.rows + 1) {
            for (j in 0 until room.seats + 1) {

                if ((i != 0 && j != 0) && !room.getRoom()[i][j].equals("S")) {
                    currentIncome += if (i <= frontHalf) {
                        10
                    } else {
                        8
                    }
                }
            }
        }
        return currentIncome
    }

    private fun totalIncome(room: Room): Int {
        var income = 0
        if (room.rows * room.seats <= 60) {
            income = room.rows * room.seats * 10
        } else {
            val frontHalf = room.rows / 2
            val backHalf = room.rows - frontHalf
            income += frontHalf * room.seats * 10
            income += backHalf * room.seats * 8
        }
        return income
    }
}