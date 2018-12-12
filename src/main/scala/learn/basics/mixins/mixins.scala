package mixins

/*
  Mixins are traits which are used to compose a class.
 */

abstract class A {
  val message: String
}
class B extends A {
  val message = "I'm an instance of class B"
}
trait C extends A {
  def loudMessage = message.toUpperCase()
}

/*
  Class D has a superclass B and a mixin C

  classes can only have one superclass but many mixins
  (using the keywords extends and with respectively)
*/

class D extends B with C


abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next(): T
}

/*
  Implementation of concrete class (all abstract members T, hasNext, and next have implementations)
*/

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0
  def hasNext = i < s.length
  def next() = {
    val ch = s charAt i
    i += 1
    ch
  }
}

/*
  This trait implements foreach by continually calling the provided function f: T => Unit on the next element (next())
  as long as there are further elements (while (hasNext)). Because RichIterator is a trait, it doesn’t need to
  implement the abstract members of AbsIterator.
 */

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next())
}

/*
  Combine the functionality of StringIterator and RichIterator into a single class.
  RichStringIter has StringIterator as a superclass and RichIterator as a mixin.

  With single inheritance we would not be able to achieve this level of flexibility.
 */

object StringIteratorTest extends App {
  class RichStringIter extends StringIterator("Scala") with RichIterator
    val richStringIter = new RichStringIter
    richStringIter foreach println
}



