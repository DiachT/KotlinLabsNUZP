import com.diacht.ktest.compose.startTestUi
import me.user.helloworld.BuildConfig
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.tan
fun seed(): String = "akutnyak"

fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun minInt(x0: Int, x1: Int, x2: Int): Int {
    return minOf(x0, x1, x2)
}
fun minDouble(x0: Double, x1: Double, x2: Double): Double {
    return minOf(x0, x1, x2)
}
fun iCalculate(): Double = tan(minInt(x0 = abs(84),x1 = abs(-17),x2 = abs(123)).toDouble())
fun dCalculate(): Double = minDouble(x0 = abs(38.94),x1 = abs(74.4),x2 = abs(64.97)).pow(1.0/3.0)
fun compareEvenChars(string1: String, string2: String): Int {
    var mismatches = 0
    if (string1.length != string2.length) throw Exception("String must be equal")
    else {
        for (i in string1.indices step 2) {
            val char1 = string1[i]
            val char2 = string2[i]
            if (char1 != char2) {
                if(string1[i] == 'A' && string1[i] == 'C') mismatches++
                if (string1[i] == 'C' && string1[i] == 'T') mismatches += 2
            }
        }
    }
    return mismatches
}
fun strCalculate(
    x0: String = "ATGCJ",
    x1: String = "AAAAA"
): Int = compareEvenChars(x0, x1)

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    println("Результат першої функції: ${iCalculate()}")
    println("Результат другої функції: ${dCalculate()}")
    println("Результат третьої функції: ${strCalculate()}")
    startTestUi(seed(), labNumber())
}


