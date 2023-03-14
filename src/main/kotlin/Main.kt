fun seed(): String = "akutnyak"

fun labNumber() : Int = 1

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    var kitty = "Васько"
    kitty += " \uD83D\uDC31"
    val age = 7
    println("Кошеня №1 - $kitty віком $age років")

    val catName: String = "Мурзик \uD83D\uDC08"
    val weight: Float = 3.5f
    println("Кошеня №2 - $catName з вагою $weight кг")

    var ginger = "Рудий"
    ginger += " \uD83D\uDC06"
    val gage = 6
    val gweight: Float = 8.2f
    println("Кошеня №3 - $ginger віком $gage років та вагою $gweight кг")
}