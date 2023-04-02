import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.tanh

fun seed(): String = "AntonNikitiuk1"

fun labNumber() : Int = 2

fun iCalculate(x0: Int = -79, x1: Int = -54, x2: Int = 117, x3: Int = -7): Double {
    return tanh(x0.toDouble() + x1 + x2 + x3)
}

fun dCalculate(x0: Double = 1.12, x1: Double = 1.15, x2: Double = -7.79, x3: Double = 31.0, x4: Double = 33.6): Double {
    return cos(min(min(min(min(x0, x1), x2), x3), x4))
}

fun strCalculate(x0: String, x1: String): Int {
    var count = 0
    if (x0.length % 2 == 0 && x1.length % 2 == 0) {
        for ((e, x) in x0.withIndex()) {
            if ((x == 'T' || x == 'C') && x == x1.get(e)) {
                count += 1
            }
            if (x == 'C' && x1.get(e) == 'G') {
                count += 2
            }
        }
    }
    return count
}
fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    iCalculate()
    dCalculate()
    strCalculate("ACCGTC","ACCGTG")
    startTestUi(seed(), labNumber())
}