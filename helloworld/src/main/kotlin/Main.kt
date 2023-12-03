import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.abs
import kotlin.math.tanh
import kotlin.math.pow

fun seed(): String = "MadScientist11"


fun labNumber(): Int = BuildConfig.LAB_NUMBER


fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    val str1 = "ATGCJ"
    val str2 = "ATGJC"
    val difCount = strCalculate(str1, str2)
    println(difCount)
    startTestUi(seed(), labNumber())
}

private fun Int.pow(i: Int, p: Int) : Double {
    return i.toDouble().pow(p)
}

fun iCalculate(x0 : Int = -40, x1 : Int = 26, x2 : Int = -91, x3 : Int = 77) : Double {
    return tanh(x0.pow(x0,2) + x1.pow(x1,2) + x2.pow(x2,2) + x3.pow(x3,2))
}
fun dCalculate(x0 : Double = -121.25, x1 : Double = -27.94, x2 : Double = -2.72, x3 : Double = 40.6) : Double {
    val absVal = abs(x0) + abs(x1) + abs(x2) + abs(x3)
    return absVal.pow(1.0/3.0);
}
fun strCalculate(x0: String, x1: String): Int {
    require(x0.length == x1.length) { "Length should be the same" }

    var dif = 0

    for (i in x0.indices) {
        val charX0 = x0[i]
        val charX1 = x1[i]

        if (charX0 == 'A' || charX0 == 'C') {
            if(charX0 != charX1){
                dif += (if(i <= x0.length / 2 - 1) 2 else 1)
            }
        }
    }

    return dif
}
