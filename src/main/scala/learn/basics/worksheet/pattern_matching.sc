/*
  - Pattern matching is a mechanism for checking a value against a pattern.
  - A successful match can also deconstruct a value into its constituent parts.
  - It is a more powerful version of the switch statement in Java and it can
    likewise be used in place of a series of if/else statements.
 */

import scala.util.Random

val x: Int = Random.nextInt(10)

x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  // The last case _ is a “catch all” case for any number greater than 2. Cases are also called alternatives.
  case _ => "many"
}

def matchTest(x: Int): String = x match {
  case 1 => "one"
  case 2 => "two"
  case _ => "many"
}
matchTest(3)  // many
matchTest(1)  // one


/*
  Matching on case classes
    - Case classes are especially useful for pattern matching.
*/

abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

def showNotification(notification: Notification): String = {
  notification match {
    case Email(email, title, _) =>
      s"You got an email from $email with title: $title"
    case SMS(number, message) =>
      s"You got an SMS from $number! Message: $message"
    case VoiceRecording(name, link) =>
      s"you received a Voice Recording from $name! Click the link to hear it: $link"
  }
}
val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
val someEmail = Email("kaa@gmail.com","test","I just wanted to say HI!")
println(showNotification(someSms))
// prints You got an SMS from 12345! Message: Are you there?

println(showNotification(someVoiceRecording))
// you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123

println(showNotification(someEmail))


def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
  notification match {
      // the pattern is matched only if the email is in the list of important people.
    case Email(email, _, _) if importantPeopleInfo.contains(email) =>
      "You got an email from special someone!"
    case SMS(number, _) if importantPeopleInfo.contains(number) =>
      "You got an SMS from special someone!"
    case other =>
      showNotification(other) // nothing special, delegate to our original showNotification function
  }
}

val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

val someSms1 = SMS("867-5309", "Are you there?")
val someVoiceRecording1 = VoiceRecording("Tom", "voicerecording.org/id/123")
val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
val importantSms = SMS("867-5309", "I'm here! Where are you?")

println(showImportantNotification(someSms1, importantPeopleInfo))
println(showImportantNotification(someVoiceRecording1, importantPeopleInfo))
println(showImportantNotification(importantEmail, importantPeopleInfo))
println(showImportantNotification(importantSms, importantPeopleInfo))

/*
  Matching on type only

  def goIdle has a different behavior depending on the type of Device.
  This is useful when the case needs to call a method on the pattern.
  It is a convention to use the first letter of the type as the case identifier (p and c in this case).
*/

abstract class Device
case class Phone(model: String) extends Device{
  def screenOff = "Turning screen off"
}
case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning screen saver on..."
}

def goIdle(device: Device) = device match {
  case p: Phone => p.screenOff
  case c: Computer => c.screenSaverOn
}

/*
  Sealed which means all subtypes must be declared in the same file.
    - This assures that all subtypes are known.
    - This is useful for pattern matching because we don’t need a “catch all” case.
*/

sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

def findPlaceToSit(piece: Furniture): String = piece match {
  case a: Couch => "Lie on the couch"
  case b: Chair => "Sit on the chair"
}