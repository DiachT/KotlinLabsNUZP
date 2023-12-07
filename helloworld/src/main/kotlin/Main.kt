
import com.diacht.ktest.compose.startTestUi
import kotlinx.coroutines.*
import org.example.helloworld.BuildConfig
import java.net.URL
import kotlin.math.tanh

fun seed(): String = "Zilagar"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

suspend fun getNumberFromServer(message: String): Int {
    return withContext(Dispatchers.IO) {
        val url = URL("http://diacht.2vsoft.com/api/send-number?message=$message")
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
    val deferredList = strList.map { async { getNumberFromServer(it) } }
    val result = deferredList.awaitAll()
    println("Numbers: $result")

    val abs = result.map { Math.abs(it) }
    val maxValue   = abs.max()
    tanh(maxValue.toDouble())
}

fun main() = runBlocking {
    startTestUi(seed(), labNumber())
    val messages = listOf("one", "two", "three", "four","five","six")
    val res = serverDataCalculate(messages)
    println("Result: $res")
}