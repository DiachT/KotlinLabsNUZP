import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.tan
import kotlin.math.sqrt

fun seed(): String = "PingvinSt"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    val result1 = iCalculate()
    println(result1)
    val result2 = dCalculate()
    println(result2)
    val x0 = "ATGCT"
    val x1 = "CTCJT"
    val result3 = strCalculate(x0, x1)
    println(result3)



    startTestUi(seed(), labNumber())
}

fun dCalculate(
    x0: Double = -52.48,
    x1: Double = 15.12,
    x2: Double = 0.66,
    x3: Double = 0.84
): Double {
    return sqrt(x0 * x1 * x2 * x3)
}

fun iCalculate(x0: Int = -18, x1: Int = 17, x2: Int = -53): Double {
    return tan(x0 * x1 * x2.toDouble())
}

fun strCalculate(x0: String, x1: String): Int {
    require(x0.length == x1.length) { "x0 and x1 must have the same length" }

    var differenceCount = 0
    for (i in x0.indices) {
        val charX0 = x0[i]
        val charX1 = x1[i]

        if ((charX0 == 'T' || charX0 == 'C') && charX1 != 'T' && charX1 != 'C') {
            differenceCount++
        }
    }

    return differenceCount
}