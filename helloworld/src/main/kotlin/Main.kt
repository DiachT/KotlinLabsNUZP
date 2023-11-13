
import com.diacht.ktest.compose.startTestUi
import kotlinx.coroutines.*
import org.example.helloworld.BuildConfig
import java.net.URL
import kotlin.math.abs
import kotlin.math.ln



fun seed(): String = "lpikalova"
fun labNumber() : Int =  BuildConfig.LAB_NUMBER

suspend fun serverDataCalculate(messages: List<String>) : Double = coroutineScope {
    val deferredList = messages.map{  async { getNumberFromServer(it) } }

    val results = deferredList.awaitAll()

    val minAbsoluteValue = results.map { abs(it.toDouble()) }.minOrNull() ?: 0.0

    ln(minAbsoluteValue)
}

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
fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
}


