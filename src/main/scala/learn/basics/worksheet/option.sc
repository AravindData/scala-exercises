/*
  Scala Option[ T ] is a container for zero or one element of a given type.
  An Option[T] can be either Some[T] or None object, which represents a missing value

  For instance, the get method of Scala's Map produces Some(value) if a value
  corresponding to a given key has been found, or None if the given key is not defined in the Map.

  Option type is used frequently in Scala programs and you can compare this with the null value available in
  Java which indicate no value. For example, the get method of java.util.HashMap returns either a value stored
  in the HashMap, or null if no value was found.

  Let's say we have a method that retrieves a record from the database based on a primary key.

  def findPerson(key: Int): Option[Person]
  The method will return Some[Person] if the record is found but None if the record is not found.
 */


/*
  A powerful Scala idiom is to use the Option class when returning a value from a function that can be null.

  Simply stated, instead of returning one object when a function succeeds and null when it fails,
  your function should instead return an instance of an Option, where the instance is either:

  An instance of the Scala Some class
  An instance of the Scala None class

  Because Some and None are both children of Option, your function signature just declares that
  you're returning an Option that contains some type (such as the Int type shown below).

  At the very least, this has the tremendous benefit of letting the user of your function know what’s going on.
 */


def toInt(in: String): Option[Int] = {
  try {
    Some(Integer.parseInt(in.trim))
  } catch {
    case e: NumberFormatException => None
  }
}

/*
  Here's how this toInt function works:

  It takes a String as a parameter.
  If it can convert the String to an Int, it does so, returning it as Some(Int).
  If the String can't be converted to an Int, it returns None.
  If you're a consumer of this toInt function, your code will look something like this:

  toInt(someString) match {
      case Some(i) => println(i)
      case None => println("That didn't work.")
  }

  Why Option is better than null:

     This may not look any better than working with null in Java, but to see the value,
     you have to put yourself in the shoes of the consumer of the toInt function,
     and imagine you didn't write that function.

     In Java, if you didn't write the toInt method, you'd have to depend on the Javadoc of the toInt method.

    (1) In the first case, if you didn't look at the Javadoc for the Java toInt method,
    you might not know that toInt could return a null, and your code could potentially throw a NullPointerException.

    (2) In the second case, if you did happen to read the Javadoc, and did see that the code could return a null,
    you might handle it like this:

        Integer i = toInt(someString);
        if (i == null) {
            System.out.println("That didn't work.");
        } else {
            System.out.println(i);
        }
  That code isn't any worse than the Scala Option and match approach, but you did have to read the Javadoc to know this was needed.

  (3) In the third case, the programmer of the toInt function could handle the NumberFormatException differently,
  and return some other value besides null, in this case, perhaps zero or some other meaningless number.
 */
