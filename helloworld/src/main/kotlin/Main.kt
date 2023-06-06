import com.diacht.ktest.compose.startTestUi
import kotlin.math.*

fun seed(): String = "lanakovalevska"

fun labNumber() : Int = 2

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    println(iCalculate())
    println(dCalculate())
    println(strCalculate())
    startTestUi(seed(), labNumber())
}
fun iCalculate(x0: Int = -42, x1: Int = -110, x2: Int = -62) : Double = tanh(x0.toDouble()*x1.toDouble()*x2.toDouble())
fun dCalculate(x0: Double = -18.72, x1: Double = 1.92, x2: Double = 8.91) : Double = sin(x0*x1*x2)
fun strCalculate(x0: String = "GACCAJJAJTCJCJATCAJGTTTGTGCATCTACJJTJCGCJCAAJGAJTJTTGGATCJGAJTGJATTGCCTGCJJAGGAGCGAGGCJATTGGTAJGACCJGAAJGCGJTTGJTTTJGTJGJCTJTCTGGCGCGJGJTAGGACCCGGAAJGGJATAGAGTTJAJATCACGJAJAJATCJTATTCJCAGTTCAAATTJGJJJJTJCJCGGCACGACGJTJTJTGTCCAAGJTTGJCTGAAJACJGAGGAAJCCATJGCCCACAJTCJJGJCA", x1: String = "GACCAJJAJTCJCJATCAJGTTTGTGTATCTACJJTJCGCJCAAJGAJTJTTGGATGJGAJTGJATTGCCTGCJJAGGAGTCAGGCJATTGGTAAGACCJGAJGGCGJTTJJTTTJGTJGJCTJTCTGGCGCGJGJTAGGACCCGGAAJGGJATAGAGTTJAJATCACGJAJAJATCJTATTCJCAGTTCAAATTJGJJJJTJCJCGGCACATCGJTJTJTGTCCAAGJTTGJCTGAAJACJGAGGAAJCCATJGCCCACAJTCJJGJCA") : Int {
    var res: Int = 0
    var index: Int = x0.length-1
    while (index >= 0) {
        if (x0[index] != 'A' && x0[index] != 'C') {}
        else if (x0[index] == 'A' && x1[index] == 'A') {}
        else if (x0[index] == 'A' && x1[index] != 'A' ) {
            res +=1
        } else if (x0[index] == 'C' && x1[index] == 'T' ) {
            res +=2
        } else if (x0[index] == 'C' && x1[index] == 'C') {}
        else {
            res += 1
        }

    index--
    }

    return res
}
