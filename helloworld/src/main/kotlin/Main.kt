import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.pow

fun seed(): String = "NazarRomanchenko"


fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun iCalculate(x0: Int = 50, x1: Int = 8, x2: Int = 123, x3: Int = -31, x4: Int = 79): Double {
    // Знаходимо модулі чисел
    val absX0 = Math.abs(x0.toDouble())
    val absX1 = Math.abs(x1.toDouble())
    val absX2 = Math.abs(x2.toDouble())
    val absX3 = Math.abs(x3.toDouble())
    val absX4 = Math.abs(x4.toDouble())

    // Знаходимо мінімальне значення
    val minimum = Math.min(absX0, Math.min(absX1, Math.min(absX2, Math.min(absX3, absX4))))

    // Повертаємо результат
    return minimum.toDouble().pow(1.0/3.0)
}
fun dCalculate(
    x0: Double = -29.44,
    x1: Double = 19.84,
    x2: Double = 1.68,
    x3: Double = 2.88,
    x4: Double = 5.22,
): Double {
    val absX0 = Math.abs(x0)
    val absX1 = Math.abs(x1)
    val absX2 = Math.abs(x2)
    val absX3 = Math.abs(x3)
    val absX4 = Math.abs(x4)

    return maxOf(absX0, absX1, absX2, absX3, absX4).toDouble().pow(1.0/3.0)
}
fun strCalculate(x0: String, x1: String): Int {
    require(x0.length == x1.length) { "Довжина рядків x0 та x1 повинна бути однаковою" }
    var diff = 0
    for (i in 0 until x0.length) {
        if ( i %2  == 1 && x0[i] != x1[i]) {
            diff += if (i >= x0.length / 2) 2 else 1
        }
    }
    return diff
}



fun main(args: Array<String>) {
     println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    // startTestUi(seed(), labNumber())
    //}
//fun main(args: Array<String>) {


    val resulti = iCalculate()

    println("Результат: $resulti")


        val resultd = dCalculate()
        println("Результат: $resultd")




            val results = strCalculate("CAGATTGA", "CACATTGA")
            println("Результат: $results")

}
