val x: Int = 1 + 1 // Values cannot be re-assigned.

var y = 1 + 1 // Variables are like values, except you can re-assign them
y = 3

/*
 Anonymous function
 On the left of => is a list of parameters.
 On the right is an expression involving the parameters.
 */
(x: Int) => x + 1

val addOne = (x: Int) => x + 1 // single param
val add = (x: Int, y: Int) => x + y // multiple param
val getTheAnswer = () => 42 // no parameter

/*
  Method: Methods look and behave very similar to functions,
  but there are a few key differences between them.

  Methods are defined with the def keyword.
  def is followed by a name, parameter lists, a return type, and a body.
 */

def add(x: Int, y: Int): Int = x + y
// ** Notice how the return type is declared after the parameter list and a colon : Int. **

def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(1, 2)(3))

// no param
def name: String = System.getProperty("user.name")
println("Hello, " + name + "!")


def getSquareString(input: Double): String = {
  val square = input * input
  square.toString // Scala does have a return keyword, but it’s rarely used
}

/*
  Class: You can define classes with the class keyword followed by its name and constructor parameters

  The return type of the method greet is Unit, which says there’s nothing meaningful to return.
  It’s used similarly to void in Java and C.
  (A difference is that because every Scala expression must have some value, there is actually a singleton value of
  type Unit, written (). It carries no information.)

 */

class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}

val greeter = new Greeter("Hello, ", "!")
greeter.greet("Scala developer") // Hello, Scala developer!

/*
  Scala has a special type of class called a “case” class.
  By default, case classes are ** immutable and compared by value **
 */

case class Point(x: Int, y: Int)

val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 2)

if (point == anotherPoint) {
  println(point + " and " + anotherPoint + " are the same.")
} else {
  println(point + " and " + anotherPoint + " are different.")
} // Point(1,2) and Point(1,2) are the same.

if (point == yetAnotherPoint) {
  println(point + " and " + yetAnotherPoint + " are the same.")
} else {
  println(point + " and " + yetAnotherPoint + " are different.")
} // Point(1,2) and Point(2,2) are different.

/*
  Objects: Are single instances of their own definitions.
  You can think of them as singletons of their own classes.
  You can access an object by referring to its name.
 */

object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}

val newId: Int = IdFactory.create()
println(newId) // 1
val newerId: Int = IdFactory.create()
println(newerId) // 2

/*
  Traits: Traits are types containing certain fields and methods. Multiple traits can be combined.


 */

trait Greet1 {
  def greet(name: String): Unit
}

// Traits can also have default implementations.
trait Greet2 {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}

// You can extend traits with the **extends**e keyword and
// override an implementation with the **override** keyword.

abstract class DefaultGreeter extends Greet1

/*
class DefaultGreeter extends Greet1
Class which extends trait must be declared abstract or implement the function (greet)
 */

class CustomizableGreeter(prefix: String, postfix: String) extends Greet1 {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val customGreeter = new CustomizableGreeter("How are you, ", "?")
customGreeter.greet("Scala developer") // How are you, Scala developer?

// Multiple traits can also be extended

// Main Method
object Main {
  def main(args: Array[String]): Unit =
    println("Hello, Scala developer!")
}

// List of type "Any"
// https://docs.scala-lang.org/tour/unified-types.html

val list: List[Any] = List(
  "a string",
  732,  // an integer
  'c',  // a character
  true, // a boolean value
  () => "an anonymous function returning a string"
)

/*
  ** AnyVal vs AnyRef **

  AnyRef - AnyRef represents reference type.  All non-value types are defined as reference types
           Supertype of all objects
  Anyval - AnyVal represents value type. Supertype of all values
 */
List(5,true)
// res9: List[AnyVal] = List(5, true)

List("Hi",2,3)
// res10: List[Any] = List(Hi, 2, 3)

List()
// res11: List[Nothing] = List()

/*
  Lazy val:

    val is executed when it is defined whereas a lazy val is executed when it is accessed the first time.

    Like a def, a lazy val is not evaluated until it is invoked. But the result is saved so that subsequent invocations
    return the saved value. The memoized result takes up space in your data structure, like a val.

    As others have mentioned, the use cases for a lazy val are to defer expensive computations until
    they are needed and store their results, and to solve certain circular dependencies between values.

    Lazy vals are in fact implemented more or less as memoized defs. You can read about the
    details of their implementation here:
 */

var a = { println("a"); 15 }
lazy val b = { println("b"); a+1 }
println("-----")
a = 17
println("b is: " + b)

/*
Output of above code is:

x
-----
y
y is: 18

As it can be seen, x is printed when it's initialized,
but y is not printed when it's initialized in same way
(I have taken x as var intentionally here - to explain when y gets initialized).

Next when y is called, it's initialized as well as value of last 'x' is
taken into consideration but not the old one.
 */


/*
  Val Vs Def

  The right hand side of a def definition is evaluated on each use.
  The right hand side of a val definition is evaluated at the point of the definition itself. Afterwards, the name refers to the value.

  val x = 2
  val y = square(x)

  For instance, y above refers to 4, not square(2)
 */


/*
  CALL-BY-NAME AND CALL-BY-VALUE

  The first evaluation strategy is known as call-by-value, the second is is known as call-by-name.

  Both strategies reduce to the same final values as long as he reduced expression consists of pure functions, and
  both evaluations terminate.

  Call-by-value has the advantage that it evaluates every function argument only once.

  Call-by-name has the advantage that a function argument is not evaluated if the
  corresponding parameter is unused in the evaluation of the function body.

  Scala normally uses call-by-value.
 */

/*
  RETURN keyword

  - Recursive methods need an explicit return type in Scala.

  - For non-recursive methods, the return type is optional.
 */

/*
  SEMICOLON

  In Scala, semicolons at the end of lines are in most cases optional.
  On the other hand, if there are more than one statements on a line, they need to be separated by semicolons

  val y = x + 1; y * y
 */