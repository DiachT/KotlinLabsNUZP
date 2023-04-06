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

fun strCalculate(x0: String = "AJJGGCTJTG", x1: String = "TJJGTGTJTG"): Int {
    var mismatches = 0
    val ignoredChars = setOf('J', ' ')

    // Сравниваем символы T и C в обеих строках
    for (i in x0.indices) {
        if (x0[i] == x1[i] && x0[i] !in ignoredChars && x0[i] in setOf('T', 'C')) {
            continue  // символы совпадают, переходим к следующей итерации цикла
        }
        if (x0[i] == 'T' && x1[i] in setOf('A', 'C', 'G') ||
            x0[i] == 'C' && x1[i] in setOf('A', 'G', 'T', 'J')) {
            mismatches++  // символы не совпадают и не являются символами J или пробелами
        }
    }

    return mismatches
}
