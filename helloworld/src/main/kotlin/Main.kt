fun seed(): String = "user2"


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
    println("Кошеня №3 - Рудий з вагою віком 6 років та вагою 8.2 кг \uD83D\uDC06")
}
