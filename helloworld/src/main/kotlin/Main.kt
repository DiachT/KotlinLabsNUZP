
import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.*

fun seed(): String = "Zilagar"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")


    val result1 = iCalculate()
    println("Результат iCalculate: $result1")


    val result2 = dCalculate()
    println("Результат dCalculate: $result2")


    val x0 = "TATJGTGTACAAGAGJJACAAJGGAGAGAAJCJAGAJCCAACAJJAJCAAGCJGTJCCTCGGCGJJCTGCCGGTJCTGTTACCCCTGJCGJJATGCCCGGGGAGJGTGJAJATGGAJGJCCAGCCJCGAAGAGGGJGGJATJJTACAGTCJACGGJAJATCCGACCTTCGGCTGTGJACCGAJCAJAJAAGJTCCGJTATAAGAAGGGCTTCAJJGACTAGTJAGCJGGTCACJTCGGJTAAATTGTJGAATCJJATJJGJAGJCCCTGCGTGTGTAJCTTCJCJTCJTTJGJTTJTJCCAAGTTCCTJGGCTTCCAJTCACTATTJGCJGACJTTGCGCAJTTGGATJAGTAJCCTCCGCCGTJGCJGGTCCTJATJJAJCGAAATAJGACGGGTTJJJCCCTAAGAATGJTAJTJGJCAGGJJGGJACTJJAGGTJAJTJAGCACGCTJAGTAATCJGCJCTGG"
    val x1 = "TATJGTGTCCAAGAGJJACAAJGGAGTGAAJGJAGAJCCAACAJJAJCAAGCJGTJCCTCGGCGJJCTGCCGGTJCTGTTACCCCTGJCGJJATGCCCGGGGAGJGTGJAJATGGAJGJCCAGCCJCGAAGAGGJJGGJATJATACAGTCJACGGJAJATCCGACCTTCGGCTGTGJACCGAJCAGAJAAGJTCCGJTAJCAJAAGGGCTTCAJJGACTAGTJAGCJGGTCAJJTCGGJCAAATTGTJGAATCJJATJJCJAGJCCCGGCGTGTGTAJCTTCJCJTCJTTJGJTTCTJCCAAGTTCTTJGGCTTCCAJTCACTATTJGCJGACJTTJCGCAJTTGGATJAGTAJCCTCCGCCGTJGCJGGTCCTJATJJAJCGAAATAJGACGGGTAJJJCCCTAAGAATGJTATTJGJJAGGJJGGJACTJJAGGTJAJTJAGCACGCTJAGTAATTJGCJCTGT"

    val result = strCalculate(x0, x1)
    println("Різниця між рядками: $result")

startTestUi(seed(), labNumber())

}

fun iCalculate(x0: Int = 34, x1: Int = 2, x2: Int = -58, x3: Int = -75): Double {
    val maxValue = max(max(x0.toDouble(), x1.toDouble()), max(x2.toDouble(), x3.toDouble()))
    return cos(maxValue)
}
fun dCalculate(x0: Double = -111.24, x1: Double = -17.6, x2: Double = -44.1, x3: Double = 24.57): Double {
    val minValue = min(abs(x0), min(abs(x1), min(abs(x2),abs(x3))))
    return tanh(minValue)
}

fun strCalculate(x0: String, x1: String): Int {
    require(x0.length == x1.length) { "Довжина рядків x0 та x1 повинна бути однаковою" }

    var differences = 0
    val strLength = x0.length
    val halfLength = strLength / 2

    for (i in x0.indices) {
        val charX0 = x0[i]
        val charX1 = x1[i]

        if (charX0 == 'T' || charX0 == 'C') {
            if(charX0 != charX1){
                if(i <= halfLength - 1)
                {
                    differences += 2
                }
                else
                {
                    differences += 1
                }

            }
        }
    }

    return differences
}



