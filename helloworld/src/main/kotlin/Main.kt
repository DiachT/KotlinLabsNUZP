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
        "3d36690ef50f7c56ce95260867c82aac",
        "0ef9ff31c3545288d42b1ba5d3c094ee",
        "6099bcd9ffc3a5e86298a6530d0ef35a",
        "29dcae0d117232dd9a19618d705b0bba",
        "16f7d155ec240fbb71e08392a1fc97f5",
        "72bc596f4c6e6ad03086c54059a8aac0",
        "f8bd45bec9fa28b92169a6c3b7366269"
    )

    val result = serverDataCalculate(strList)
    println("Actual result: $result")

    println("Lab №${labNumber()} user ${seed()}")
    startTestUi(seed(), labNumber())
}
