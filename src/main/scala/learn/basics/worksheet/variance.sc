/*
  Variance is the correlation of
    subtyping relationships of complex types and the
    subtyping relationships of their component types.

  Scala supports variance annotations of type parameters of generic classes,
  to allow them to be covariant, contravariant, or invariant if no annotations are used.

  The use of variance in the type system allows us to make intuitive connections between complex types,
  whereas the lack of variance can restrict the reuse of a class abstraction.

  class Foo[+A] // A covariant class
  class Bar[-A] // A contravariant class
  class Baz[A]  // An invariant class
*/

trait Iterator[+A] {
  def hasNext(): Boolean
  def next(): A
}

/*
  Covariance

      A type parameter A of a generic class can be made covariant by using the annotation +A.

      The Iterator trait returns the type A and it’s covariant.
      That means that we can convert Iterator[A] to Iterator[B] whenever B is a base class of A.

*/

trait Writer[-A] {
  def write(value: A): Unit
}

/*
  Contravariance

      The Writer trait receives the type A and it’s contravariant.
      That means that we can convert Writer[A] to Writer[B] whenever B is a derived class of A.

      Small Tip: I use to get confused between the two terms.

                 In Scala it’s easier to remember the sign that we should use: + means “more” types
                 (base classes, broader definition allowed) and 

                 — means “less” types (derived classes, narrower definition allowed).

 */



abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

/*
  Both Cat and Dog are subtypes of Animal.

  The Scala standard library has a generic immutable sealed abstract class List[+A] class,
  where the type parameter A is covariant.

  This means that a List[Cat] is a List[Animal] and
                  a List[Dog] is also a List[Animal].

  Intuitively, it makes sense that a list of cats and a list of dogs are each lists of animals,
  and you should be able to substitute either of them for a List[Animal].

  In the following example, the method printAnimalNames will accept a list of animals as an argument and
  print their names each on a new line.

  If List[A] were not covariant, the last two method calls would not compile,
  which would severely limit the usefulness of the printAnimalNames method.
 */



object CovarianceTest extends App {
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalNames(cats)
  // Whiskers
  // Tom

  printAnimalNames(dogs)
  // Fido
  // Rex
}

/*
  Contravariance

      A type parameter A of a generic class can be made contravariant by using the annotation -A.

      This creates a subtyping relationship between the class and its type parameter that is similar,
      but opposite to what we get with covariance.

      That is, for some class Writer[-A], making A contravariant implies that for two types A and B
      where A is a subtype of B, Writer[B] is a subtype of Writer[A].

      Consider the Cat, Dog, and Animal classes defined above for the following example:

      A Printer[A] is a simple class that knows how to print out some type A.
      Let’s define some subclasses for specific types:
*/

abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit =
    println("The cat's name is: " + cat.name)
}

/*
  If a Printer[Cat] knows how to print any Cat to the console, and a
       Printer[Animal] knows how to print any Animal to the console, it makes sense that a
       Printer[Animal] would also know how to print any Cat.

  The inverse relationship does not apply, because a Printer[Cat] does not know how to print any Animal to the console.
  Therefore, we should be able to substitute a Printer[Animal] for a Printer[Cat], if we wish,
  and making Printer[A] contravariant allows us to do exactly that.
 */

object ContravarianceTest extends App {
  val myCat: Cat = Cat("Boots")

  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter

  printMyCat(catPrinter)
  printMyCat(animalPrinter)
}

/*
  Output:

  The cat's name is: Boots
  The animal's name is: Boots
 */