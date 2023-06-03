import com.diacht.ktest.compose.startTestUi
import kotlin.math.*

fun seed(): String = "lanakovalevska"

fun labNumber() : Int = 2

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    println(iCalculate())
    println(dCalculate())
    startTestUi(seed(), labNumber())
}
fun iCalculate(x0: Int = -42, x1: Int = -110, x2: Int = -62) : Double = tanh(x0.toDouble()*x1.toDouble()*x2.toDouble())
fun dCalculate(x0: Double = -18.72, x1: Double = 1.92, x2: Double = 8.91) : Double = sin(x0*x1*x2)

