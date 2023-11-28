import com.diacht.ktest.compose.startTestUi
import me.nikita.helloworld.BuildConfig
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.net.URL
import kotlin.math.sin

fun seed(): String = "Nikita-Pityurenko"

fun labNumber() : Int = BuildConfig.LAB_NUMBER






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

suspend fun serverDataCalculate(strList: List<String>) : Double = coroutineScope {
    val numbers = strList.map { async { getNumberFromServer(it) } }
    val product = numbers.fold(1.0) { acc, number -> acc * number.await() }
    sin(product)
}

fun main (args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")


    startTestUi(seed(), labNumber())
}