import com.diacht.ktest.compose.startTestUi
import me.user.helloworld.BuildConfig
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.tan
fun seed(): String = "akutnyak"

fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun iCalculate(x0  :Int = 84, x1 : Int = -17, x2 : Int = 123): Double = tan(minOf(abs(x0),abs(x1), abs(x2)).toDouble())
fun dCalculate(x0 : Double = 38.94, x1 : Double = 74.4, x2 : Double = 64.97): Double = minOf(abs(x0),abs(x1), abs(x2)).pow(1.0/3.0)
fun compareEvenChars(string1: String, string2: String): Int {
    var mismatches = 0
    if (string1.length != string2.length) throw Exception("String must be equal")
    else {
        for (i in string1.indices) {
            val char1 = string1[i]
            val char2 = string2[i]
            if (char1 != char2){
                if (char1 == 'C' && char2 == 'T') mismatches += 2
                else if (char1 == 'A' || char1 =='C') mismatches++
            }
        }
        return mismatches
    }
}
fun strCalculate(
    x0: String = "ATCGCJ",
    x1: String = "AAAATA"
): Int = compareEvenChars(x0, x1)

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    println("Результат першої функції: ${iCalculate()}")
    println("Результат другої функції: ${dCalculate()}")
    println("Результат третьої функції: ${strCalculate()}")
    startTestUi(seed(), labNumber())
}


