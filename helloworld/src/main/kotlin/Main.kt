import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig

import kotlinx.coroutines.*
import java.net.URL

fun seed(): String = "progvan"
fun labNumber() : Int = BuildConfig.LAB_NUMBER
suspend fun getNumberFromServer(string: String): Int {
    return withContext(Dispatchers.IO) {
        val url = URL("http://diacht.2vsoft.com/api/send-number?message=$string")
        val connection = url.openConnection()
        connection.connect()
        val input = connection.getInputStream()
        val buffer = ByteArray(128)
        val bytesRead = input.read(buffer)
        input.close()
        String(buffer, 0, bytesRead).toInt()
    }
}
suspend fun serverDataCalculate(messages: List<String>) : Double = coroutineScope {
    val deferredList = messages.map{  async { getNumberFromServer(it) } }
    val maxAbsolute = deferredList.awaitAll().map { Math.abs(it) }.maxOrNull()
    maxAbsolute?.let { Math.tanh(it.toDouble()) } ?: 0.0
}
fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
    }
