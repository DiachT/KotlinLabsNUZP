fun seed(): String = "Zaytsev Alexander"

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

         var cat = "Рудий"
         cat += " \uD83D\uDC06"
         val b = 6
         val a: Float = 8.2f
         println("Кошеня №3 - $cat віком $b років з вагою $a кг" )
        }



    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.

