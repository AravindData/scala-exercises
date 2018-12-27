/*
Case Classes

  - Case classes are good for modeling immutable data
*/

/*
Notice how the keyword new was not used to instantiate the Book case class.
This is because case classes have an apply method by default which
takes care of object construction.

When you create a case class with parameters, the parameters are public vals.
*/

case class Book(isbn: String)

val frankenstein = Book("978-0486282114")


case class Message(sender: String, recipient: String, body: String)
val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

println(message1.sender)  // prints guillaume@quebec.ca

// You can’t reassign message1.sender because it is a val (i.e. immutable).
// It is possible to use vars in case classes but this is discouraged.
message1.sender = "travis@washington.us"  // this line does not compile


// Comparision : Case classes are compared by structure and not by reference:
case class Messageval(sender: String, recipient: String, body: String)

val message2 = Messageval("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
val message3 = Messageval("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")

// Even though message2 and message3 refer to different objects, the value of each object is equal.
val messagesAreTheSame = message2 == message3  // true

// Copying : You can create a (shallow) copy of an instance of a case class simply by using the copy method.
// You can optionally change the constructor arguments.
// The recipient of message4 is used as the sender of message5 but the body of message4 was copied directly.

case class Messages(sender: String, recipient: String, body: String)
val message4 = Messages("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
message5.sender  // travis@washington.us
message5.recipient // claire@bourgogne.fr
message5.body  // "Me zo o komz gant ma amezeg"