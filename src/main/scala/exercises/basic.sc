println(1.to(10))
println(1 to 10)
// Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

println("Hello, " ++ "Scala!")
// Hello, Scala!

/*
  Method Calls
    - Methods are applied on expressions using the dot notation.
    - Operators are methods as well
 */

println("Hello, Scala!".size)

println("Hello, Scala!".toUpperCase)

println(-42.abs)
// 42

println(3 + 2 == 3.+(2))
// true

println(16.toHexString)

println((0 until 10))
// Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

println((0 until 10).contains(10))
// false

println("foo".drop(1))
// oo

println("bar".take(2))
// ba


object Demo {
  def main(args: Array[String]) {
    println( "Returned Value : " + addInt(5,7) )
  }

  def addInt( a:Int, b:Int ) : Int = {
    var sum:Int = 0
    sum = a + b

    return sum
  }
}

/*
 You can refer to its members using the usual dot notation
 println(Demo.main(Array("a"))) ->  Returned Value : 12
*/


// \>scalac Demo.scala
// \>scala Demo
// Returned Value : 12

def factorial(n: Int): Int =
  if (n == 1) 1
  else factorial(n - 1) * n

factorial(3)
factorial(4)

val x = 0
def f(y: Int) = y + 1
val result = {
  val x = f(3)
  x * x
} + 4

println(result)