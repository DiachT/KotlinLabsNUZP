import me.tetiana.helloworld.BuildConfig
import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.tan
fun seed(): String = "akutnyak"

fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun iCalculate(): Double {                     //iCaltulate() = tan(min(abs(x0),abs(x1),abs(x2)
    val x: Array<Int> = arrayOf(84, -17, -123) //Аргументи функції
    var n : Int = 0
    while (n < 3) {
        x[n] = abs(x[n])                       //Модулі Аргументів
        n++;
    }
    val iresult = tan(x.min().toDouble())       //Тангенс мінімального аргументу
    return iresult
}
fun dCalculate(): Double{                       //dCaltulate() = (min(abs(x0),abs(x1),abs(x2)^(1/3)
    val x: Array<Double> = arrayOf(38.94, 74.4, 64.97)
    var n : Int = 0
    while (n < 3) {
        x[n] = abs(x[n])                        //Модулі Аргументів
        n++;
    }
    val sqrt3 : Double = 1.0 / 3.0              //Корінь третього ступеня
    val dresult = x.min().pow(sqrt3)                //Розрахунок
    return dresult
}
fun strCalculate() : Int{
    var x0 :String = "ATGCJ"            //x0 (A,C) сравнить с x1 количество несовпадений
    var x1 = x0                         //если x0 = C "И" x1 = T, тогда к результату
    var matches = 0; var i= 0; var ct = 0
    do{
        if((x0[0] == x1[i])||(x0[3] == x1[i])) matches++
        if(x0[3] == x1[i] || (x0[1] == x1[i])) ct += 2
        i++
    }
    while (i < x1.length)
    val strresult = x0.length + ct - matches
    return strresult
}
fun prints(){
    println("Лабораторна робота №${labNumber()} користувача ${seed()} \n" +
            "Результат першої функції: ${iCalculate()} \n" +
            "Результат другої функції: ${dCalculate()} \n" +
            "Результат третьої функції: ${strCalculate()}")
}

fun main(args: Array<String>) {
    prints()
    startTestUi(seed(), labNumber())
}


