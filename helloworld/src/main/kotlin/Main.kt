import com.diacht.ktest.compose.startTestUi

fun seed(): String = "lanakovalevska"

fun labNumber() : Int = 2

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    startTestUi(seed(), labNumber())
}