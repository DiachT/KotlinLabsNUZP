
    import com.diacht.ktest.compose.startTestUi
    import kotlin.math.*

fun seed(): String = "adobeMUSE"

 fun labNumber() : Int = 2

 fun main(args: Array<String>) {
     println("Лабораторна робота №${labNumber()} користувача ${seed()}")

     startTestUi(seed(), labNumber())


    }
    fun iCalculate(x0: Int = -112, x1: Int = -68, x2: Int = -67, x3: Int = -101): Double {
        val max = maxOf(x0, x1, x2, x3)
        return tanh(max.toDouble())
        val result = iCalculate()
        println(result)
    }
    fun dCalculate(x0: Double = -32.67, x1: Double = 0.72, x2: Double = 47.88): Double {
        val maxAbs = max(abs(x0), max(abs(x1), abs(x2)))
        return cos(maxAbs)
        val result2= dCalculate()
        println(result2)
    }
    fun strCalculate(x0: String = "ATGCJY", x1: String = "ATGCJY"): Int {
            var result = 0


            for (i in x0.indices) {
                if ((x0[i] == 'T' || x0[i] == 'C') && x0[i] == x1[i]) {
                }
                else if ((x0[i] == 'T' || x0[i] == 'C') && x0[i] != x1[i]) {
                    if (i >= x0.length / 2) {
                        result += 2
                    } else {
                        result += 1
                    }
                }
            }

            return result
        }