import com.diacht.ktest.compose.startTestUi
import  me.alexander.helloworld.BuildConfig
fun seed(): String = "ne4eHIOLLIka"
fun labNumber() : Int = BuildConfig.LAB_NUMBER
fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
}
