import com.diacht.ktest.Product
import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.juicefactory.ORANGE
import com.diacht.ktest.library.BuildConfig

fun seed(): String = "stressed-owl"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

fun main() {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
}

fun getSimulationObject() = JuiceFactory(FreshJuiceStorage())