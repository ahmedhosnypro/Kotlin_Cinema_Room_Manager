package cinema

import java.util.*

object Profit {
    fun calculateProfit() {
        println("Enter the number of rows:")
        val scanner = Scanner(System.`in`)
        val rows = scanner.nextInt()
        println("Enter the number of seats in each row:")
        val seats = scanner.nextInt()
        var profit: Int
        if (rows * seats <= 60) {
            profit = rows * seats * 10
        } else {
            val frontHalf = rows / 2
            val backHalf = rows - frontHalf
            profit = frontHalf * seats * 10
            profit += backHalf * seats * 8
        }
        println("Total income:")
        println("$$profit")
    }
}