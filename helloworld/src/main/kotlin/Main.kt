import org.junit.jupiter.api.Assertions.assertTrue

fun seed(): String = "MadScientist11"

fun labNumber(): Int = 1

fun main(args: Array<String>) {
    println("Лабораторна робота номер один користувача ${seed()}")

    var kitty = "Васько"
    kitty += " \uD83D\uDC31"
    val age = 7
    println("Кошеня номер один - $kitty віком $age років")

    val catName: String = "Мурзик \uD83D\uDC08"
    val weight: Float = 3.5f
    println("Кошеня номер два - $catName з вагою $weight кг")


    val cat: String = "Рудий \uD83D\uDC06"
    val catWeight: Float = 8.2f
    val catAge: Int = 6
    println("Кошеня №3 - $cat, віком $catAge з вагою $catWeight кг")
}