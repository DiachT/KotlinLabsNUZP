 import com.diacht.ktest.compose.startTestUi
 import me.user.helloworld.BuildConfig
 import kotlin.math.abs
 import kotlin.math.cos
 import kotlin.math.max
 import kotlin.math.sqrt

 fun seed(): String = "Alexandr"


 fun labNumber() : Int = BuildConfig.LAB_NUMBER
 fun  iCalculate(x0:Int=-42,x1:Int=14,x2:Int=-121):Double {
val a=max(x0,x1)
  val b: Int =max(a,x2)
  return sqrt(b.toDouble())
 }
 fun dCalculate(x0:Double=55.35,x1:Double=-16.72,x2:Double=92.82) : Double{
  val a=max(abs(x0),abs(x1))
  val b=max(abs(x2),a)
  return cos(b)
 }
 fun strCalculate(x0:String,x1:String) : Int{
  var a=0
  var y=0
  do {
   if(x0[y]=='T' || x0[y]=='C'){
    if ((x0[y] == 'T')  && (x1[y] != 'J') && (x1[y] != 'T'))
     a++
    if ((x0[y] == 'C')  && (x1[y] != 'C') )
     a++
   }
   y++
  }while (y!=x0.length)
  return a
 }

 fun main(args: Array<String>) {
   println("Лабораторна робота №${labNumber()} користувача ${seed()}")

  startTestUi(seed(), labNumber())
}

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.

