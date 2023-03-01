import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlin.math.sin
import kotlin.math.abs

fun seed(): String = "stressed-owl"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    println("Result of the first function: ${iCalculate()}")
    println("Result of the second function: ${dCalculate()}")
    println("Result of the third function: ${strCalculate()}")
    startTestUi(seed(), labNumber())
}

fun strCalculate(
    x0: String = "TJACG",
    x1: String = "ACTJG"
): Int = compareEvenChars(x0, x1)

fun compareEvenChars(string1: String, string2: String): Int {
    var mismatches = 0

    val string1SecondHalf = string1.substring(string1.length / 2, string1.length)
    val string2SecondHalf = string2.substring(string2.length / 2, string2.length)

    if (string1.length != string2.length) throw Exception("String must be equal")
    else {
        for (i in string1.indices step 2) {
            for (j in string2.indices step 2) {
                if (string1[i] != string2[j]) {
                    if (string1[i] in string1SecondHalf && string2[j] in string2SecondHalf)
                        mismatches += 2
                    else
                        mismatches++
                }
            }
        }
    }
    return mismatches
}

fun dCalculate(
    x0: Double = -14.3,
    x1: Double = 74.8,
    x2: Double = 111.36,
    x3: Double = 70.84,
    x4: Double = 13.3
): Double = sin(abs(listOf(x0, x1, x2, x3, x4)))

// Returns the sum of the absolute values
fun abs(numbers: List<Double>): Double {
    var result = 0.0
    numbers.forEach { result += abs(it) }
    return result
}
fun iCalculate(
    x0: Int = 11,
    x1: Int = -43,
    x2: Int = 85,
    x3: Int = 73,
    x4: Int = 57
): Double = Math.cbrt(max(listOf(x0, x1, x2, x3, x4)).toDouble())
// Returns the max number of list
fun max(numbers: List<Int>) = numbers.max()

