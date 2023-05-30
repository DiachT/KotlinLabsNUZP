
    import com.diacht.ktest.compose.startTestUi
    import kotlin.math.*
    import kotlinx.coroutines.*

    import java.net.URL

fun seed(): String = "adobeMUSE"

 fun labNumber() : Int = 4


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






    suspend fun getNumberFromServer(s: String): Int {
        return withContext(Dispatchers.IO) {
            val url = URL("http://diacht.2vsoft.com/api/send-number?message=" + s)
            val connection = url.openConnection()
            connection.connect()
            val input = connection.getInputStream()
            val buffer = ByteArray(128)
            val bytesRead = input.read(buffer)
            input.close()
            String(buffer, 0, bytesRead).toInt()
        }
    }

    suspend fun serverDataCalculate(strList: List<String>): Double = coroutineScope {
        val deferredList = strList.mapIndexed { index, element ->
            async {
                val number = getNumberFromServer(element).toInt()
                number * number
            }
        }
        val numbers = deferredList.awaitAll()
        println(numbers)
        val sum = numbers.sum()
        val result = tanh(sum.toDouble())
        println(result)
        return@coroutineScope result
    }

    suspend fun main(args: Array<String>) {
        println("Лабораторна робота №${labNumber()} користувача ${seed()}")
        
        startTestUi(seed(), labNumber())


    }