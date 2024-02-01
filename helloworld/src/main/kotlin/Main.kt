import com.diacht.ktest.compose.startTestUi
import me.alexander.helloworld.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import kotlinx.coroutines.*
import  kotlin.math.ln
fun seed(): String = "ne4eHIOLLIka"
fun labNumber() : Int = BuildConfig.LAB_NUMBER
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
suspend fun serverDataCalculate(strList: List<String>) : Double = coroutineScope {
    val defferendList = strList.map { async { getNumberFromServer(it) } }
    val res = defferendList.awaitAll()
    //println("Numbers: $res")
    val pos=res.filter { it>=0 }.sumByDouble { it.toDouble() }
    val neg=res.filter { it<0 }.sumByDouble { it.toDouble() }
    //val sum = res.map{ it.toDouble()}.reduce { acc, next -> acc + next }
    ln(pos-neg)
}
fun main() = runBlocking {
    val result=serverDataCalculate(listOf("x0","x1","x2","x3","x4","x5"))
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    println("Resurt: $result")
    //startTestUi(seed(), labNumber())
}


