package traits

/*
Traits become especially useful as generic types [A]
and with abstract methods.
 */

trait Iterator[A]{
  def hasNext: Boolean
  def next() : A
}

/*
Extending the trait Iterator[A] requires a type A
and implementations of the methods hasNext and next.
 */

class IntIterator(to: Int) extends Iterator[Int]{

  private var current = 0

  // we can implement any abstract members of the trait using the override keyword
  override def hasNext: Boolean = current < to

  // since the trait was extended it next method must return an Int.
  override def next(): Int =  {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}

object iteratorMain {
  def main(args: Array[String]): Unit = {
    val iterator = new IntIterator(10)
    println(iterator.next())  // returns 0
    println(iterator.next())  // returns 1
  }
}
