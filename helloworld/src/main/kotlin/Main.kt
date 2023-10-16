import com.diacht.ktest.FactoryItf
import com.diacht.ktest.compose.startTestUi
import me.malno.helloworld.BuildConfig

fun seed(): String = "Malnormalulos-git"
fun labNumber() : Int = BuildConfig.LAB_NUMBER

val storage = MyStorage()
val cafeMachine = CafeMachine(storage)
val factory = MyFactory(storage, cafeMachine)

fun getSimulationObject() : FactoryItf {
	return factory
}

fun main(args: Array<String>) {
	println("Лабораторна робота №${labNumber()} користувача ${seed()}")
	startTestUi(seed(), labNumber())
}