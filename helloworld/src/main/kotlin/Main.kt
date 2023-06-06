import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.tan
import kotlin.math.sqrt
import kotlin.math.abs

fun seed(): String = "PingvinSt"


fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    val iCalcResult = iCalculate()
    println("Результат iCalculate: $iCalcResult")

    val dCalcResult = dCalculate()
    println("Результат dCalculate: $dCalcResult")

    val strCalcResult = strCalculate()
    println("Результат strCalculate: $strCalcResult")

    startTestUi(seed(), labNumber())
    }

fun iCalculate(x0: Int = -61, x1: Int = -42, x2: Int = 32, x3: Int = 60): Double {
    val sum = abs(x0) + abs(x1) + abs(x2) + abs(x3)
    return sqrt(sum.toDouble())
}

fun dCalculate(
    x0: Double = -23.4,
    x1: Double = -9.3,
    x2: Double = -33.6,
    x3: Double = -31.39,
    x4: Double = -41.8
): Double {
    val sum = abs(x0) + abs(x1) + abs(x2) + abs(x3) + abs(x4)
    return tan(sum)
}

fun strCalculate(x0: String = "GJTCJCAGTC", x1: String = "GJTCJAAGAC"): Int {
    require(x0.length == x1.length) { "Рядки повинні мати однакову довжину" }

    var difference = 0

    for (i in x0.indices) {
        val charX0 = x0[i]
        val charX1 = x1[i]

        if (charX0 != charX1) {
            difference++
        }
    }

    return difference
}
