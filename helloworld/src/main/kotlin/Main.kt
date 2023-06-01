import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.ln

fun seed(): String = "PingvinSt"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

suspend fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    val strList = listOf("x0", "x1", "x2", "x3", "x4", "x5")
    val calculationResult = serverDataCalculate(strList)
    println(calculationResult)

    startTestUi(seed(), labNumber())
}

suspend fun serverDataCalculate(strList: List<String>): Double = withContext(Dispatchers.IO) {
    val values = mutableListOf<Int>()

    for (str in strList) {
        val url = "http://diacht.2vsoft.com/api/send-number?message=$str"
        val response = sendHttpGetRequest(url)
        values.add(response)
    }

    val maxAbs = values.map { kotlin.math.abs(it) }.maxOrNull() ?: 0
    val result = ln(maxAbs.toDouble())

    result
}

private fun sendHttpGetRequest(url: String): Int {
    val connection = URL(url).openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    val responseCode = connection.responseCode
    val responseBody = connection.inputStream.bufferedReader().use { it.readText() }

    connection.disconnect()

    return if (responseCode == HttpURLConnection.HTTP_OK) {
        try {
            responseBody.toInt()
        } catch (e: NumberFormatException) {
            0
        }
    } else {
        0
    }
}