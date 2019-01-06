/*
  Object

    - An object is a class that has exactly one instance.

    - It is created lazily when it is referenced, like a lazy val.

    - As a top-level value, an object is a singleton.

    - As a member of an enclosing class or as a local value, it behaves exactly like a lazy val.

    - An object is a value.

    - The definition of an object looks like a class, but uses the keyword object
*/

object Box

object Logger {
  def info(message: String): Unit = println(s"INFO: $message")
}

/*
  Companion Objects:

    - An object with the same name as a class is called a companion object.
    - Conversely, the class is the object’s companion class.
    - A companion class or object can access the private members of its companion.
    - Use a companion object for methods and values which are not specific to instances of the companion class.

  Scala classes cannot have static variables or methods.
  Instead a Scala class can have what is called a singleton object, or sometime a companion object.

  A singleton object (Main) is declared using the object keyword. Here is an example:

  object Main {
    def sayHi() {
        println("Hi!");
    }
  }

  Main.sayHi();

  Notice how you write the full name of the object before the method name. No object is instantiated.
  It is like calling a static method in Java, except you are calling the method on a singleton object instead.

    -  A companion object must be defined inside the same source file as the class.

  class Main {
    def sayHelloWorld() {
        println("Hello World");
    }
  }

  object Main {
      def sayHi() {
          println("Hi!");
      }
  }

  In this class you can both instantiate Main and call sayHelloWorld() or call the sayHi() method on the
  companion object directly, like this:

  var aMain : Main = new Main();
  aMain.sayHelloWorld();

  Main.sayHi();
*/

import scala.math._

case class Circle(radius: Double) {
  import Circle._
  def area: Double = calculateArea(radius)
}

object Circle {
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
}

val circle1 = new Circle(5.0)

circle1.area

/*
  NOTE:
    The class Circle has a member area which is specific to each instance,
    and the singleton object Circle has a method calculateArea which is available to every instance.
 */

class Email(val username: String, val domainName: String)

object Email {
  def fromString(emailString: String): Option[Email] = {
    emailString.split('@') match {
      case Array(a, b) => Some(new Email(a, b))
      case _ => None
    }
  }
}

val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
scalaCenterEmail match {
  case Some(email) => println(
    s"""Registered an email
       |Username: ${email.username}
       |Domain name: ${email.domainName}
     """)
  case None => println("Error: could not parse email")
}

// The object Email contains a factory fromString which creates an Email
// instance from a String. We return it as an Option[Email] in case of parsing errors.


/*
  Class and Object


 */


