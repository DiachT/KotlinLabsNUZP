import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlin.math.*

fun seed(): String = "picardKotlin"

fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun iCalculate(x0 : Int = 27, x1 : Int = 98, x2 : Int = 53) : Double{
    var result : Double = sqrt((x0 * x1 * x2).toDouble()) // Розрахунок по формулі
    return result // Повернення результату
}

fun dCalculate(x0 : Double = 104.55, x1 : Double = -182.56, x2 : Double = -30.3, x3 : Double = 0.51) : Double{
    var result : Double = tanh(maxOf(abs(x0), abs(x1), abs(x2), abs(x3))) // Розрахунок по формулі
    return result // Повернення результату
}

fun strCalculate(x0 : String = "AGTCJA", x1 : String = "AJCTGJ") : Int{
    var result : Int = 0

    for (i in x0.indices) { // Цикл для проходження по рядку
        if(x0[i] == 'T' || x0[i] == 'C'){ // Умова за якої починається порівняння з другою строкою
            if (x0[i] != x1[i]) { // Порівняння символу першої строки з відповідним символом другої
                if (i < x0.length / 2) { // Перевірка на місцезнаходження елемента в першій або другій частині рядка
                    result += 2
                } else {
                    result++
                }
            }
        }
    }
    return result // Повернення результату
}

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    iCalculate()
    dCalculate()
    strCalculate()
    startTestUi(seed(), labNumber())
}