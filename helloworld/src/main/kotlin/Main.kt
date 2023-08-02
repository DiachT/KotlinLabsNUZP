import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlinx.coroutines.*
import java.net.URL
import kotlin.math.*

fun seed(): String = "yzadorozhnij"

fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun iCalculate(x0 : Int = 109, x1 : Int = 92, x2 : Int = 57, x3 : Int = 61) : Double{ // Створення ф-ції з 3 цілочисленні аргументами що повертає дробове число
    var res : Double = cbrt(minOf(x0,x1,x2,x3).toDouble()); // Розрахунок кубічного кореню з найменшого числа вибірки
    return res; // Повернення результату після розрахувань
}

fun dCalculate(x0 : Double = -44.8, x1 : Double = 55.88, x2 : Double = -7.65, x3 : Double = 16.24) : Double{ // Створення ф-ції з 3 дробовими аргументами що повертає дробове число
    var res : Double = cbrt(minOf(abs(x0), abs(x1), abs(x2), abs(x3))); // Розрахунок кубічного кореню з найменшого числа вибірки приведених до абсолюту
    return res; // Повернення результату після розрахувань
}

fun strCalculate(x0 : String = "AGTCJA", x1 : String = "AJJTTJ") : Int{
    var res : Int = 0
    println("start")
    for (i in x0.indices step 2) { // Цикл для проходження по рядку з подвійним кроком
        if (x0[i] != x1[i]) { // Порівняння символів першої строки та другої
            if (i <= x0.length / 2) { // Додавання +2 до результату у разі знаходження символу у першій половині рядка
                res += 2
            } else { // Додавання +1 до результату у разі знаходження символу у другій половині рядка
                res++
            }
        }
    }
    return res // Повернення результату
}

suspend fun getNumberFromServer(req: String): Int {
    return withContext(Dispatchers.IO) {
        val url = URL("http://diacht.2vsoft.com/api/send-number?message=" + req)
        val connection = url.openConnection()
        connection.connect()
        val input = connection.getInputStream()
        val buffer = ByteArray(128)
        val bytesRead = input.read(buffer)
        input.close()
        String(buffer, 0, bytesRead).toInt()
    }
}

suspend fun serverDataCalculate(strList: List<String>) : Double = runBlocking {
    var result : Double = 0.0;
    val deferredList = strList.map { async { getNumberFromServer(it).toDouble().pow(2.0) } }
    val numbers = deferredList.awaitAll()
    result = sqrt(numbers.sum().toDouble())
    return@runBlocking result;
}

suspend fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    //println(iCalculate()) //Результат завдання 1 лаб 2
    //println(dCalculate()) //Результат завдання 2 лаб 2
    //println(strCalculate()) //Результат завдання 3 лаб 2

    println(serverDataCalculate(listOf("user1", "user2", "user3", "user4", "user5", "user6"))); //Результат завдання лаб 4

    startTestUi(seed(), labNumber())
}