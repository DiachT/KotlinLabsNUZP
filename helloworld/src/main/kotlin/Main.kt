import com.diacht.ktest.compose.startTestUi
import me.user.helloworld.BuildConfig
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
    val cbrt : Double = 1.0 / 3.0              //Корінь третього ступеня - число у ступені 1/3
    val dresult = x.min().pow(cbrt)            //Корінь третього ступеня мінімального аргументу
    return dresult
}
fun strCalculate() : Int{
    var x0 :String = "ATGCJ"    //Аргументи функції
    var x1 = x0
    var matches = 0; var i= 0; var ct = 0
    do{
        if((x0[0] == x1[i])||(x0[3] == x1[i])) matches++ //Якщо символи А та С у рядку х0 співпадає з символами у рядку х1
        if(x0[3] == x1[i] || (x0[1] == x1[i])) ct += 2   //Якщо символи С та Т у рядку х0 співпадає з символами у рядку х1
        i++
    }
    while (i < x1.length)
    val strresult = x0.length + ct - matches //Кількість неспівпадань дорівнює: довжина рядку плюс співпадання символів С та Т, мінус співпадання символів А та С
    return strresult
}
fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    println("Результат першої функції: ${iCalculate()}")
    println("Результат другої функції: ${dCalculate()}")
    println("Результат третьої функції: ${strCalculate()}")
    startTestUi(seed(), labNumber())
}


