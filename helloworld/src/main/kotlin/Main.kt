 fun seed(): String = "adobeMUSE"

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

     val catName1: String = "Рудий \uD83D\uDC06"
     val weight1: Float = 8.2f
     val age1 = 6
     println("Кошеня №3 - $catName1 віком $age1 років та з  вагою $weight1 кг")


    }