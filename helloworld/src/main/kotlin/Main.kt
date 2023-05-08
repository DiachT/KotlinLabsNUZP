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


     val strList = listOf("1", "2", "3", "4", "5") // приклад аргументів
     val result = runBlocking { serverDataCalculate(strList) }
     println(result) // виведе результат розрахунку на екран

    startTestUi(seed(), labNumber())
    }


suspend fun serverDataCalculate(strList: List<String>): Double = coroutineScope {
    val baseUrl = "http://diacht.2vsoft.com/api/send-number"
    var sum = 0
    for (i in strList.indices) {
        val url = "$baseUrl?num=${strList[i]}"
        val result = URL(url).readText().toInt()
        sum += result
    }
    val absoluteSum = sum.absoluteValue
    ln(absoluteSum.toDouble())
}