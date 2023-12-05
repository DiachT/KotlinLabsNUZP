
fun seed(): String = "ne4eHIOLLIka"
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
    val cat3: String="Рудий \uD83D\uDC06"
    val cat3age: Int=6
    val cat3weight: Float=8.2f
    println("Кошеня №3 - $cat3 віком $cat3age з вагою $cat3weight кг")
}
