import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlinx.coroutines.*
import java.net.URL
import kotlin.math.pow
import kotlin.math.tanh

fun seed(): String = "stressed-owl"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

suspend fun serverDataCalculate(strList: List<String>): Double = coroutineScope {
    val deferredResults = strList.map {
        async {
            val serverUrl = "http://diacht.2vsoft.com/api/send-number?message=$it"
            getNumberFromServer(serverUrl)
        }
    }

    val numbers = deferredResults.awaitAll()

    val sum = numbers.sumOf { it.toDouble().pow(3) }
    tanh(sum)
}

suspend fun getNumberFromServer(url: String): Int {
    return withContext(Dispatchers.IO) {
        val serverURL = URL(url)
        val connection = serverURL.openConnection()
        connection.connect()

        val input = connection.getInputStream()
        val buffer = ByteArray(128)
        val bytesRead = input.read(buffer)

        input.close()
        String(buffer, 0, bytesRead).toInt()
    }
}

fun main() = runBlocking {
    val strList = listOf("1", "2", "3", "4", "5", "6")
    val result = serverDataCalculate(strList)
    println(result)
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
}

fun getSimulationObject() = JuiceFactory(FreshJuiceStorage())