fun seed(): String = "AhhTeem"
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

     val catNameRed: String = "Рудий \uD83D\uDC06"
     val weightRed: Float = 8.2f
     val ageRed = 6
     println("Кошеня №3 - $catNameRed з вагою $weightRed кг віком $ageRed років")
    }