import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.abs
import kotlin.math.cbrt
import kotlin.math.max
import kotlin.math.min


fun seed(): String = "lpikalova"


fun labNumber() : Int =  BuildConfig.LAB_NUMBER

fun iCalculate(x0: Int = 15, x1: Int = 43, x2: Int = 123): Double {
    val minAbs = min(abs(x0.toDouble()), min(abs(x1.toDouble()), abs(x2.toDouble())))
    val cubicRoot = cbrt(minAbs)
    return cubicRoot }
fun dCalculate(x0: Double = 53.96, x1: Double = 2.96, x2: Double = 45.5, x3: Double = -45.6): Double {
    val maxAbs = max(abs(x0), max(abs(x1), max(abs(x2), abs(x3))))
    val cubicR= cbrt(maxAbs)
    return cubicR
}


fun strCalculate(x0: String, x1: String): Int {
    var mismatches = 0;

    for (i in 0..x0.length - 1 step 2) {
        val char1 = x0[i]
        val char2 = x1[i]
        if (char1 != char2) {
            if (i > (x0.length-1) / 2) mismatches += 2
            else mismatches++
        }
    }
    return mismatches;
}


fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
}