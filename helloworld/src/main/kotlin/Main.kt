fun seed(): String = "Sergey1Getman"

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
     val thirdcat: String = "Рудий \uD83D\uDC06"
     val thirdweight: Float = 8.2f
     val thirdage = 6
     println("Кошеня №3 - $thirdcat віком $thirdage з вагою $thirdweight кг")

    }