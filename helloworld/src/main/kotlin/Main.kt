import kotlinx.coroutines.*
 import me.user.helloworld.BuildConfig
import java.net.URL
import com.diacht.ktest.compose.startTestUi
import kotlin.math.ln

 fun seed(): String = "Niaekk"
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
  val minAbsoluteValue = res.map{ it.toDouble()}.reduce { acc, next -> acc * next }
  ln(minAbsoluteValue)
 }

fun main(args: Array<String>) {


    startTestUi(seed(), labNumber())
 }


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.

