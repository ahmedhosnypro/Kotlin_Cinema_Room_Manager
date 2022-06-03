package cinema

import cinema.Profit.calculateProfit

object Cinema {
    @JvmStatic
    fun main(args: Array<String>) {
        val cinemaRoom = CinemaRoom()
        println(cinemaRoom)
        calculateProfit()
    }
}