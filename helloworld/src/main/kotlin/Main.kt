import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.*

fun seed(): String = "progvan"

fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun iCalculate(x0:Int = 61, x1:Int = 116, x2:Int = -63, x3:Int = 25): Double {
    return sin(x0.toDouble() + x1.toDouble() + x2.toDouble() + x3.toDouble())
}

fun dCalculate(x0:Double = -4.7, x1:Double = -119.78, x2:Double = -11.55, x3:Double = -8.88, x4:Double = -25.22): Double {
    return cbrt(x0 * x1 * x2 * x3 * x4)
}

fun strCalculate(x0: String, x1: String) : Int {
        var result:Int = 0

        for (i in x0.indices) {
            val charX0 = x0[i]
            val charX1 = x1[i]

            if ((charX0 == 'T' || charX0 == 'C') && (charX1 != 'C' && charX1 != 'T')) {
                result += 1
            } else if ((charX0 == 'T' && charX1 == 'C') || (charX0 == 'C' && charX1 == 'T')) {
                result += 2
            } else {
                result += 0
            }
        }
        return result
}

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
    }
