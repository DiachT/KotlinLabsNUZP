import com.diacht.ktest.compose.startTestUi
import me.nikita.helloworld.BuildConfig
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

fun seed(): String = "Nikita-Pityurenko"

fun labNumber() : Int = BuildConfig.LAB_NUMBER




    fun iCalculate(x0: Int = 17, x1: Int = 121, x2: Int = -68, x3: Int = 32, x4: Int = -1):
            Double {
        val sum = abs(x0.toDouble()) + abs(x1.toDouble()) + abs(x2.toDouble()) + abs(x3.toDouble()) + abs(x4.toDouble())
        return cos(sum)
    }
    fun dCalculate(x0: Double = 33.64, x1: Double = -40.0, x2: Double = -8.75, x3: Double = -26.19, x4: Double = 40.95): Double {
        return sin(x0 * x1 * x2 * x3 * x4)
    }
    fun strCalculate(x0: String, x1: String): Int {
        var count = 0
        for (i in x0.indices) {
            if (i % 2 == 0) { // проверяем только парные символы
                if (x0[i] != x1[i]) {
                    if (!((x0[i] == 'T' && x1[i] == 'J') || (x0[i] == 'J' && x1[i] == 'T'))) {

                        count++
                    }
                }
            }
        }
        return count
    }
fun main (args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")


    startTestUi(seed(), labNumber())
}