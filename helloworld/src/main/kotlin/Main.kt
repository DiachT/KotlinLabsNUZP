import com.diacht.ktest.compose.startTestUi
import me.malno.helloworld.BuildConfig
import kotlin.math.*

fun seed(): String = "Malnormalulos-git"


fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun iCalculate(x0: Int = -98, x1: Int = -75, x2: Int = 47, x3: Int = 75, x4: Int = 90) : Double {
	return tanh(x0.toDouble().pow(3.0) + x1.toDouble().pow(3.0) + x2.toDouble().pow(3.0) + x3.toDouble().pow(3.0) + x4.toDouble().pow(3.0))
}

fun dCalculate(x0: Double = 48.0, x1: Double = -82.88, x2: Double = -124.12, x3: Double = -0.74) : Double {
	return sin(x0 * x1 * x2 * x3)
}

fun strCalculate(x0: String, x1: String) : Int {
	var counterOfDiferent: Int = 0
	for (i in x0.indices){
		if(x0[i] == 'T' && x1[i] == 'J' 	||
		   x0[i] == 'J' && x1[i] == 'T')
			continue
		else if(x0[i] != x0[i])
			counterOfDiferent++
	}
	return counterOfDiferent
}

fun main(args: Array<String>) {
	println("Лабораторна робота №${labNumber()} користувача ${seed()}")
	
	startTestUi(seed(), labNumber())
}