import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlin.math.*

fun seed(): String = "AntonNikitiuk1"

fun labNumber() : Int = 2

fun iCalculate(x0: Int = -79, x1: Int = -54, x2: Int = 117, x3: Int = -7): Double {
    return tanh(x0.toDouble() + x1 + x2 + x3)
}

fun dCalculate(x0: Double = 1.12, x1: Double = 1.15, x2: Double = -7.79, x3: Double = 31.0, x4: Double = 33.6): Double {
    return cos(minOf(abs(x0),abs(x1),abs(x2),abs(x3),abs(x4))) //Повертає мінімальне число з 5 приведених до модулю за допомогою abs
}

var template1 = "ACCGTT"
var template2 = "ACGCTA"
fun strCalculate(x0: String = template1, x1: String = template2): Int {
    var count = 0
    for (symbol in x0.indices) {
        if (x0[symbol] == 'T' || x0[symbol] == 'C') {
            if(x0[symbol] != x1[symbol]){
                if(x0[symbol] == 'C' || x1[symbol] == 'C' || x1[symbol] == 'G') {
                    count += 2;
                }
                else {
                    count += 1;
                }
            }
        }
    }
    return count
}
fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    iCalculate()
    dCalculate()
    strCalculate()
    startTestUi(seed(), labNumber())
}