/*

Abstract class and Trait can both be used as interface to define properties for
extending classes to implement

Abstract class

* defines methods that enables inheriting subclass to use
* defines abstract methods that requires implementation in subclass
* provides a common interface that allows interchanges among subclasses

These defined properties can be either abstract or concrete depending on your specific problems

 */

abstract class Pet { // or, trait Pet, also works
var age: Int = 0 // concrete
val hello: String // abstract
val greeting: String = s"I like to play with you!" // concrete
def sayHello = { println(hello) }
  override def toString = s"$hello, $greeting"
}

/*

Abstract fields

For an abstract field, no matter whether it is val, var or def,
it requires implementation in the extending classes.

Therefore, we will need to provide a value for the abstract field hello
when extend Pet in a subclass; otherwise, the compiler would complain something
like error: class Dog needs to be abstract, since value hello in class P
et of type String is not defined. Specifically, we could extend Pet to construct
a Dog class in the following way.

 */

class Dog extends Pet {
  val hello = "Woof"
}

val dog = new Dog
// dog: Dog = Woof, I like to play with you!

dog.sayHello
// Woof

dog.age
// res0: Int = 0

println(dog)
// Woof, I like to play with you!

/*

Concrete Fields

For concrete fields that are already defined in the abstract class,
we need to provide them with initial values in advance.
Concrete val and var fields behave slightly differently when we would like to change
their initial values when extend the abstract class.

For a concrete val field or def method, we need to override its value in the subclasses
in order to change the initial value.

 */

class Cat extends Pet {
  val hello = "Meow"
  override val greeting: String = s"I don't want to play with you!" // override initial value
  override def sayHello = { println( "SILENCE" ) } // override initial value
}

val cat = new Cat
// cat: Cat = Meow, I don't want to play with you!

cat.sayHello
// SILENCE

println(new Cat)
// Meow, I don't want to play with you!

/*

Reason to use Abstract class:

* You want to create a base class that requires constructor arguments.
* The code will be called from Java code.

Since  trait doesn’t allow for constructor arguments.

*/

abstract class PetC (name: String) { // trait doesn't allow this
var age: Int = 0 // concrete
val hello: String // abstract
val greeting: String = s"I like to play with you!" // concrete
def sayHello = { println(hello) }
  override def toString = s"$hello, $greeting"
}

class Dog_ (name: String) extends PetC (name) {
  val hello = "Woof"
  override val greeting: String = s"I am $name and I like to play with you!"
}

val ben = new Dog_("Ben")
// ben: Dog = Woof, I am Ben and I like to play with you!

/*

Trait

* Besides the points above, trait in general is more powerful and can be used in many cases.
* A class can extend multiple trait, but only one abstract class.
* Moreover, trait can be combined together with abstract class to take advantage of its constructor parameter.
* These all make trait very flexible and more commonly used to implement base behavior.

*/

trait Angry {
  var isAngry: Boolean
}

trait BallLover {
  def catchBall = { println("catch the ball!") }
}

abstract class PetT (name: String) {
  var age: Int = 0 // concrete
  val hello: String // abstract
  val greeting: String = s"I like to play with you!" // concrete
  def sayHello = { println(hello) }
  override def toString = s"$hello, $greeting"
}

class DogT (name: String) extends PetT (name) with Angry with BallLover {
  val hello = "Woof"
  var isAngry = true
  override val greeting: String = s"I am $name and I like to play with you!"
}

val tom = new DogT("Tom")
// tom: Dog = Woof, I am Tom and I like to play with you!

tom.isAngry
// res0: Boolean = true

tom.catchBall
// catch the ball!

tom.isAngry = false
tom.isAngry
// res1: Boolean = false

/*

You can also limit a trait so that it can only be added to classes that extend a certain superclass.
For example, if you want BallLover to be a trait that can only be extended by subclasses of Pet,
you just need to specify it so during its definition.

trait BallLover extends Pet {
  def catchBall: = { println("catch the ball!") }
}
In this case, any classes that are not extended from Pet wouldn’t be able to extend BallLover
and would get an error: illegal inheritance instead.

*/