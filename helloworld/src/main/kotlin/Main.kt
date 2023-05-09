import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlinx.coroutines.*
import kotlin.math.pow
import kotlin.math.tanh

fun seed(): String = "stressed-owl"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

suspend fun serverDataCalculate(strList: List<String>): Double = coroutineScope {
    val elements = strList.map { arg -> arg.toDouble() }
    var result = tanh(
        elements[0].pow(3.0) + elements[1].pow(3.0) + elements[2].pow(3.0) + elements[0].pow(3.0) + elements[1].pow(3.0) + elements[2].pow(3.0)
    )
    result
}

fun main() = runBlocking {
    val strList = listOf("1", "2", "3", "4", "5", "6")
    val result = serverDataCalculate(strList)
    println(result)
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
}

fun getSimulationObject() = JuiceFactory(FreshJuiceStorage())