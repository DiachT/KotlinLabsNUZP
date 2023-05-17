import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlinx.coroutines.*
import java.net.URL
import kotlin.math.absoluteValue
import kotlin.math.ln



fun seed(): String = "Nikarionec"


fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    val strList = listOf("1", "2", "3", "4", "5")

    runBlocking {
        val result = serverDataCalculate(strList)
        println(result)
        startTestUi(seed(), labNumber())
    }
}

suspend fun serverDataCalculate(strList: List<String>): Double = coroutineScope {
    val baseUrl = "http://diacht.2vsoft.com/api/send-number"
    val deferredResults = strList.map { num ->
        async { performServerRequest(baseUrl, num) }
    }
    val results = deferredResults.awaitAll()
    val sum = results.sum()
    val absoluteSum = sum.absoluteValue
    ln(absoluteSum.toDouble())
}

suspend fun performServerRequest(baseUrl: String, num: String): Int = withContext(Dispatchers.IO) {
    val url = "$baseUrl?num=$num"
    val result = URL(url).readText().toInt()
    result
}