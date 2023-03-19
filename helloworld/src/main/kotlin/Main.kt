import kotlin.math.*
import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig


fun seed(): String = "Kovaal-mari"


fun labNumber() : Int = BuildConfig.LAB_NUMBER


fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")


    fun iCalculate(x0: Int = 100, x1: Int = 28, x2: Int = 127, x3: Int = -37): Double {
        return sqrt(x0.toDouble().pow(2) + x1.toDouble().pow(2) + x2.toDouble().pow(2) + x3.toDouble().pow(2)) }


    fun dCalculate(x0: Double = 47.3, x1: Double = 88.58, x2: Double = 56.35, x3: Double = -11.07): Double {
        return tanh(minOf(abs(x0), abs(x1), abs(x2), abs(x3)))
    }

    fun strCalculate(x0: String = "ATGJJATG", x1: String = "ATGCCATG"): Int {
        require(x0.length == x1.length && x0.length %2 == 0 ) { "x0 and x1 must have the same length" }
        val halfLength = x0.length / 2
        var count = 0
        for (i in x0.indices) {
            if (x0[i] != x1[i]) {
                if (i < halfLength) {
                    count += 2
                } else {
                    count += 1
                }
            }
        }
        return count
    }

    println(dCalculate())
    println(iCalculate())
    println(strCalculate())
    startTestUi(seed(), labNumber())
}