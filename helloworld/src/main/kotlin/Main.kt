fun seed():String="Зелік"

fun labNumber(): Int = 1

fun main(args:Array<String>){
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    var kitty="Броша"
    kitty +="\uD83D\uDC31"
    val age = 15
    println("Кошеня №1 - $kitty віком $age років")

    val catName: String="Кіт \uD83D\uDC31"
    val weight:Float = 3.5f
    println("Кошеня №2 - $catName з вагою $weight кг")

    val cat3: String="Рудий \uD83D\uDC06"
    val age3=6
    val weight3:Float = 8.2f
    println("Кошеня №3 - $cat3 віком $age3 років, з вагою $weight кг")
}