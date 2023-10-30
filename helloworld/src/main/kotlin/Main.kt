import com.diacht.ktest.FactoryItf
import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlinx.coroutines.*
//import me.malno.helloworld.BuildConfig
import java.net.URL

fun seed(): String = "Malnormalulos-git"
fun labNumber() : Int = BuildConfig.LAB_NUMBER

val storage = MyStorage()
val cafeMachine = CafeMachine(storage)
val factory = MyFactory(storage, cafeMachine)

fun getSimulationObject() : FactoryItf {
	return factory
}

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


suspend fun serverDataCalculate(messages: List<String>) : Double = coroutineScope {
	val deferredList = messages.map{  async { getNumberFromServer(it) } }
	var XsProduct = 1.toLong()
	deferredList.awaitAll().forEach{ XsProduct *= it }
	Math.cbrt(XsProduct.toDouble())
}

fun main(args: Array<String>){
	println("Лабораторна робота №${labNumber()} користувача ${seed()}")
	startTestUi(seed(), labNumber())
}