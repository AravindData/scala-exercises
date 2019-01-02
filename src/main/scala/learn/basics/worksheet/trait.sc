/*
  Trait

    A trait can be used just like a Java interface. As with interfaces,
    just define the methods in your trait that you want extending classes to implement
*/

trait BaseSoundPlayer {
  def play
  def close
  def pause
  def stop
  def resume
}

/*
   - Class implements one trait it will use the extends keyword

   - Trait can extend another trait

   - If a class extends a trait but does not implement the methods defined in that trait,
     it must be declared "abstract"

   - If a class implements multiple traits, it will extend the first trait
     (or a class, or abstract class), and then use "with" for other traits
*/

trait DonutShoppingCartDao {
  def add(donutName: String): Long
  def update(donutName: String): Boolean
  def search(donutName: String): String
  def delete(donutName: String): Boolean
}

class DonutShoppingCart extends DonutShoppingCartDao {

  override def add(donutName: String): Long = {
    println(s"DonutShoppingCart-> add method -> donutName: $donutName")
    1
  }
  override def update(donutName: String): Boolean = {
    println(s"DonutShoppingCart-> update method -> donutName: $donutName")
    true
  }
  override def search(donutName: String): String = {
    println(s"DonutShoppingCart-> search method -> donutName: $donutName")
    donutName
  }
  override def delete(donutName: String): Boolean = {
    println(s"DonutShoppingCart-> delete method -> donutName: $donutName")
    true
  }
}

val donutShoppingCart1: DonutShoppingCart = new DonutShoppingCart()
donutShoppingCart1.add("Vanilla Donut")
donutShoppingCart1.update("Vanilla Donut")
donutShoppingCart1.search("Vanilla Donut")
donutShoppingCart1.delete("Vanilla Donut")

// Since our DonutShoppingCart class extended the trait DonutShoppingCartDao,
// you can also assign the type of the DonutShoppingCart object to the
// trait DonutShoppingCartDao

val donutShoppingCart2: DonutShoppingCartDao = new DonutShoppingCart()
donutShoppingCart2.add("Vanilla Donut")
donutShoppingCart2.update("Vanilla Donut")
donutShoppingCart2.search("Vanilla Donut")
donutShoppingCart2.delete("Vanilla Donut")

/*
  If a class extends a trait but does not implement the methods defined in that trait,
  it must be declared abstract
 */

// must be declared abstract because it does not implement BaseSoundPlayer methods
abstract class JavaSoundPlayer extends BaseSoundPlayer {
  def play   {}
  def close  {}
}

/*
  Abstract and concrete fields in traits

  In a trait, define a field with an initial value to make it concrete,
  otherwise give it no initial value to make it abstract

  In the class that extends the trait, you’ll need to define the values for the abstract fields,
  or make the class abstract.

  The Pizza class demonstrates how to override the numToppings field:
 */

trait PizzaTrait {
  var numToppings: Int     // abstract
  val maxNumToppings = 10  // concrete
}

class Pizza extends PizzaTrait {
  var numToppings = 0      // override not needed
}






