fun seed(): String = "Nikita-Pityurenko"

fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun main (args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    startTestUi(seed(), labNumber())

    var kitty = "Васько"
    kitty += " \uD83D\uDC31"
    val age = 7
    println("Koшеня №1 $kitty вiком $age pokiв")

    val catName: String = "Мурзик \uD83D\uDC08"
    val weight: Float = 3.4f
    println("Koшеня №2 - $catName з вагою $weight кг")

    var kit = "Рудий"
    kit += "\uD83D\uDC06"
    val age2 = 6
    val weight2: Float = 8.2f
    println("Кошеня №3 $kit віком $age2 років та вагою $weight2 кг")
}