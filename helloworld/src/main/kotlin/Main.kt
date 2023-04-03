import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlin.math.abs
import kotlin.math.ln
import kotlin.math.max
import kotlin.math.tan
fun seed(): String = "Nikarionec"


fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    
    val result1 = iCalculate()
    println(result1)
    val result2 = dCalculate()
    println(result2)
    val result3 = strCalculate()
    println(result3)

    startTestUi(seed(), labNumber())
    }
fun iCalculate(x0: Int = 41, x1: Int = -125, x2: Int = 49, x3: Int = 10, x4: Int = 67): Double {
    val max = maxOf(x0, x1, x2, x3, x4)
    return ln(max.toDouble())
}
fun dCalculate(x0: Double = 65.72, x1: Double = -11.22, x2: Double = -102.12, x3: Double =-12.96, x4: Double = -47.38): Double {

    val arg = abs(x0) + abs(x1) + abs(x2) + abs(x3) + abs(x4)
    return tan(arg)
}

fun strCalculate(x0: String = "A G T C J", x1: String = "A G C T J"): Int {
    var mismatchCount = 0
    for (i in x0.indices) {
        val charX0 = x0[i]
        val charX1 = x1[i]
        if ((charX0 == 'T' || charX0 == 'C') && (charX1 == 'T' || charX1 == 'C')) {
            if (charX0 != charX1) {
                mismatchCount++
            }
        } else if (charX0 != charX1 && charX0 != 'J' && charX1 != 'J') {
            mismatchCount =+ 0
        }
    }
    return mismatchCount
}
