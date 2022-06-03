package cinema

class CinemaRoom internal constructor() {
    private var seats = Array(8) {
        arrayOfNulls<String>(
            9
        )
    }

    init {
        for (i in 0..7) {
            for (j in 0..8) {
                if (i == 0 && j == 0) {
                    seats[i][j] = " "
                } else if (i == 0) {
                    seats[i][j] = j.toString()
                } else if (j == 0) {
                    seats[i][j] = i.toString()
                } else seats[i][j] = "S"
            }
        }
    }

    override fun toString(): String {
        val ret = StringBuilder("Cinema:\n")
        for (strings in seats) {
            for (j in strings.indices) {
                if (j == seats.size) {
                    ret.append(strings[j])
                } else {
                    ret.append(strings[j]).append(" ")
                }
            }
            ret.append("\n")
        }
        return ret.toString()
    }
}