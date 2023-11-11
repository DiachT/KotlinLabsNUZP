import com.diacht.ktest.compose.startTestUi
import me.user.helloworld.BuildConfig
import kotlin.math.ln

fun seed(): String = "Irina0101"
fun labNumber(): Int = BuildConfig.LAB_NUMBER

fun iCalculate(x0: Int = 66, x1: Int = -110, x2: Int = -121): Double {
    return Math.tanh(maxOf(x0, x1, x2).toDouble())
}

fun dCalculate(x0: Double = -5.5, x1: Double = -26.25, x2: Double = -115.5, x3: Double = -17.86): Double {
    val maxAbs = listOf(Math.abs(x0), Math.abs(x1), Math.abs(x2), Math.abs(x3)).maxOrNull() ?: 0.0
    return ln(maxAbs)
}

fun strCalculate(x0: String, x1: String): Int {
    require(x0.length == x1.length) { "Both input strings must have the same length" }

    var result = 0

    for (i in x0.indices) {
        val charX0 = x0[i]
        val charX1 = x1[i]

        if (charX0 == 'A' || charX0 == 'C') {
            val valueToAdd = if (i >= x0.length / 2) 2 else 1
            if (charX0 != charX1) {
                result += valueToAdd
            }
        }
    }

    return result
}

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    val functionOneResult = iCalculate()
    println("Результат обчислення iCalculate(): $functionOneResult")

    val functionTwoResult = dCalculate()
    println("Результат обчислення dCalculate(): $functionTwoResult")

    val x0 = "ATGCAA"
    val x1 = "ATGCAC"

    val difference = strCalculate(x0, x1)
    println("\nРезультат обчислення strCalculate()\nРізниця між x0 і x1: $difference")

    startTestUi(seed(), labNumber())
}
