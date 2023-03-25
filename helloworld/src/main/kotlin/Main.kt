fun seed(): String = "AntonNikitiuk1"

fun labNumber() : Int = 1

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    val catName1: String = "Васько \uD83D\uDC31"
    val age = 7
    println("Кошеня №1 - $catName1 віком $age років")
    val catName2: String = "Мурзик \uD83D\uDC08"
    val weight2: Float = 3.5f
    println("Кошеня №2 - $catName2 з вагою $weight2 кг")
    val catName3: String = "Рудий \uD83D\uDC06"
    val weight1: Float = 8.2f
    val ageCat3 = 6
    println("Кошеня №3 - $catName3 віком $ageCat3 років з вагою $weight1 кг")
}
