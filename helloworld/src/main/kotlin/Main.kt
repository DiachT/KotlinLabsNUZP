import kotlin.math.*
import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import kotlinx.coroutines.*



fun seed(): String = "Kovaal-mari"


fun labNumber() : Int = BuildConfig.LAB_NUMBER


suspend fun getNumberFromServer(s: String): Int {
    return withContext(Dispatchers.IO) {
        val url = URL("http://diacht.2vsoft.com/api/send-number?message=" + s)
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
    var result: Double = 0.0
    val deferredList = strList.mapIndexed { index, element ->
        async {
            val number = getNumberFromServer(element).toDouble()
            number * number
        }
    }
    val squaredNumbers = deferredList.awaitAll()
    result = ln(squaredNumbers.sum())
    result
}

suspend fun main(args: Array<String>) {
    //println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    //startTestUi(seed(), labNumber())

    val strList = listOf("x0", "x1", "x2", "x3", "x4", "x5")
    println("Значення x:")
    for (element in strList) {
        val number = getNumberFromServer(element)
        println(number)
    }
    val calculationResult = serverDataCalculate(strList)
    println("Результат обчислення: $calculationResult")
}
