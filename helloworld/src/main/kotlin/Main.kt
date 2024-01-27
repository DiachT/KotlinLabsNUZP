import com.diacht.ktest.compose.startTestUi
import me.user.helloworld.BuildConfig
import kotlinx.coroutines.*
import java.net.URL
import kotlin.math.cbrt

fun seed(): String = "Irina0101"
fun labNumber(): Int = BuildConfig.LAB_NUMBER
suspend fun fetchDataFromServer(id: String): Int {
    val url = URL("http://diacht.2vsoft.com/api/send-number?message=$id")
    val connection = url.openConnection()
    connection.connect()

    val input = connection.getInputStream()
    val buffer = ByteArray(128)
    val bytesRead = input.read(buffer)

    input.close()
    return String(buffer, 0, bytesRead).toInt()
}

suspend fun serverDataCalculate(strList: List<String>): Double = coroutineScope {
    val deferredResults = strList.map { id ->
        async {
            fetchDataFromServer(id)
        }
    }

    val results = deferredResults.awaitAll()
    val minResult = results.minOrNull() ?: throw NoSuchElementException("No elements in the result list")

    return@coroutineScope cbrt(minResult.toDouble())
}

fun main() = runBlocking {
    val strList = listOf(
        "strList[0]",
        "strList[1]",
        "strList[2]",
        "strList[3]",
        "strList[4]",
        "strList[5]",
        "strList[6]"
    )

    val result = serverDataCalculate(strList)
    println("Actual result: $result")

    println("Lab №${labNumber()} user ${seed()}")
    startTestUi(seed(), labNumber())
}
