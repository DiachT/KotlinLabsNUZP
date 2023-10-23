 import com.diacht.ktest.compose.startTestUi
 import me.user.helloworld.BuildConfig
 import kotlin.math.*

 fun seed(): String = "Niaekk"


 fun labNumber() : Int = BuildConfig.LAB_NUMBER
 fun  iCalculate(x0:Int=-89,x1:Int=-77,x2:Int=50,x3:Int=-55,x4:Int=87):Double {
val a=abs(x0)+abs(x1)+abs(x2)+abs(x3)+abs(x4)
  val b: Int =max(a,x2)
  return sqrt(a.toDouble())
 }
 fun dCalculate(x0:Double=25.01,x1:Double=-78.66,x2:Double=42.84,x3:Double=50.22,x4:Double=33.5) : Double{
  val a=max(abs(x0),abs(x1))
  val b=max(abs(x2),abs(x3))
  val c=max(a,b)
  val d=max(c,abs(x4))
  return ln(d)
 }
 fun strCalculate(x0:String,x1:String) : Int{
  var a=0
  var y=0
  do {
   if(x0[y]!=x1[y]) {
    if ((x0[y] == 'C' && x1[y] == 'T') || (x0[y] == 'T' && x1[y] == 'C')) {
     a = a + 2
     y = y + 2
    }
    else{
    a++
    y=y+2}
   }
   else y=y+2
  }while (y!=x0.length)
  return a
 }
 fun main(args: Array<String>) {
   println("Лабораторна робота №${labNumber()} користувача ${seed()}")

  startTestUi(seed(), labNumber())
}

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.

