fun seed(): String = "stressed-owl"

fun labNumber(): Int = 1

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    var kitty = "Васько"
    kitty += " \uD83D\uDC31"
    val age = 7

    println("Кошеня №1 - $kitty віком $age років")
    val catNameFirst: String = "Мурзик \uD83D\uDC08"
    val weightFirstCat: Float = 3.5f
    println("Кошеня №2 - $catNameFirst з вагою $weightFirstCat кг")

    val catNameSecond: String = "Рудий \uD83D\uDC06"
    val ageSecondCat = 6
    val weightSecondCat: Float = 8.2f

    println("Кошеня №3 - $catNameSecond з вагою $weightSecondCat кг та віком $ageSecondCat років")
}