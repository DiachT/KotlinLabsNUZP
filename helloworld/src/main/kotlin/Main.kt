import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import com.diacht.ktest.FactoryItf

fun seed(): String = "progvan"
fun labNumber() : Int = BuildConfig.LAB_NUMBER

val storage = MyStorage();
val juicePress = JuicePress(storage);
val factory = CafeFactory(storage, juicePress);

fun getSimulationObject() : FactoryItf {
    return factory;
}

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
    }
