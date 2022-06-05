fun pepTalk(name: String): String {
    val array = name.split(" ").toTypedArray()

    println("Good luck!")
    return try {
        "Don't lose the towel, traveler ${array[0]} ${array[1]}!"
    } catch (e: ArrayIndexOutOfBoundsException) {
        "Don't lose the towel, nameless one."
    }
}

fun main() {
    val name = readln()
    val advice = pepTalk(name)
    print(advice)
}