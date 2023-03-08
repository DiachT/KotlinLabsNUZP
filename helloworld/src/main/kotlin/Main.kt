import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.tan
import kotlin.math.tanh

fun seed(): String = "Sergey1Getman"

 fun labNumber() : Int = BuildConfig.LAB_NUMBER

 fun main(args: Array<String>) {
     println("Лабораторна робота №${labNumber()} користувача ${seed()}")
     startTestUi(seed(), labNumber())
     var kitty = "Васько"
     kitty += " \uD83D\uDC31"
     val age = 7
     println("Кошеня №1 - $kitty віком $age років")

     val catName: String = "Мурзик \uD83D\uDC08"
     val weight: Float = 3.5f
    println("Кошеня №2 - $catName з вагою $weight кг")
     val thirdcat: String = "Рудий \uD83D\uDC06"
     val thirdweight: Float = 8.2f
     val thirdage = 6
     println("Кошеня №3 - $thirdcat віком $thirdage з вагою $thirdweight кг")

     fun iCalculate(x0:Int = -109,
     x1:Int = -75,
     x2:Int = -61,
     x3: Int = -5) : Double {
         val max1 = max(abs(x0), abs(x1))
         val max2 = max(abs(x2), abs(x3))
         val max3: Double = max(max1, max2).toDouble()
         return tanh(max3)
     }
     iCalculate()
     fun dCalculate(x0:Double = -48.76,
                    x1:Double = -89.7,
                    x2:Double = -74.82,
                    x3:Double = 144.0,
                    x4:Double = 25.84) {
            return println(tan(x0*x1*x2*x3*x4))
     }
     dCalculate()
     fun strCalculate(
         x1:String = "JTTCG",
         x2:String = "ATGCJ") {
         var result : Int = 0
         var x = 0
         while (x < 2) {
             if (x1[x] !== x2[x]) result++
             ++x
         }
         while (x in 2..4) {
             if (x1[x] !== x2[x]) {
                 result++
                 result++
             }
             ++x
         }
         return println(result)
     }
     strCalculate()
 }