import com.diacht.ktest.compose.startTestUi
import me.alexander.helloworld.BuildConfig
import kotlin.math.min
import kotlin.math.sin
import kotlin.math.cbrt
fun seed(): String = "ne4eHIOLLIka"
fun labNumber(): Int = BuildConfig.LAB_NUMBER
fun iCalculate(x0: Int=5, x1: Int=67, x2: Int=57, x3: Int=-75, x4: Int=80): Double {
    val a=minOf(x0, x1, x2, x3, x4)
    return sin(a.toDouble())}
fun dCalculate(x0: Double=-25.38, x1: Double=-111.3, x2: Double=-137.76): Double =cbrt(Math.abs(x0) * Math.abs(x1) * Math.abs(x2))
fun strCalculate(x0: String, x1: String): Int {
    var result = 0
    var index = 0
    do {
        val charX0 = x0[index]
        val charX1 = x1[index]
        val doubleDifference = if (charX0 == 'C' && charX1 == 'G' || charX0 == 'G' && charX1 == 'C') 2 else 1
        if (charX0 != charX1) {
            result += doubleDifference
        }
        index++
    } while (index < x0.length)
    return result
}
fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    val iResult = iCalculate()
    val dResult = dCalculate()
    val strResult = strCalculate("ATGCJ", "TACGJ")
    println("iCalculate result: $iResult")
    println("dCalculate result: $dResult")
    println("strCalculate result: $strResult")
    startTestUi(seed(), labNumber())
}
