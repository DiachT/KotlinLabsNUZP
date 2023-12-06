
import kotlinx.coroutines.*
import org.example.helloworld.BuildConfig
import java.lang.Math.tanh
import java.net.URL

fun seed(): String = "Zilagar"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

fun main() = runBlocking {
    //startTestUi(seed(), labNumber())
    val messages = listOf("one", "two", "three", "four","five","six")
    val res = serverDataCalculate(messages)
    println("Result: $res")
}

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

suspend fun serverDataCalculate(strList: List<String>): Unit = coroutineScope {
    val deferredList = strList.map { async { getNumberFromServer(it) } }
    val result = deferredList.awaitAll()
    println("Numbers: $result")



    val abs = result.map { Math.abs(it) }
    val maxValue   = abs.max()
    val res = tanh(maxValue.toDouble())
    println("$res ")
    }

