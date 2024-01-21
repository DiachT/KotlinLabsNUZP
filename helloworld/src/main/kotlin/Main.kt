import com.diacht.ktest.compose.startTestUi
import kotlinx.coroutines.*
import me.user.helloworld.BuildConfig
import java.net.URL
import kotlin.math.cbrt

fun seed(): String = "Irina0101"
fun labNumber(): Int = BuildConfig.LAB_NUMBER

suspend fun getNumberFromServer(): Int {
    return withContext(Dispatchers.IO) {
        val url = URL("http://diacht.2vsoft.com/api/send-number?message=test")
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
    val deferredResults = strList.map { str ->
        async(Dispatchers.IO) {
            getNumberFromServer().toDouble()
        }
    }

    val numbers = deferredResults.awaitAll()
    val minNumber = numbers.minOrNull() ?: 0.0
    cbrt(minNumber)
}

suspend fun main() {
    val strList = listOf("x0", "x1", "x2", "x3", "x4", "x5", "x6")
    val result = serverDataCalculate(strList)
    println("Result: $result")

    println("Lab №${labNumber()} user ${seed()}")
    startTestUi(seed(), labNumber())
}