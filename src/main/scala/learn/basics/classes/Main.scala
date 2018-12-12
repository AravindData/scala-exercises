package classes

object AccessMain {
  def main(args: Array[String]): Unit = {

    val point1 = new Point(2, 3)
    println(point1.x) // 2
    println(point1) // prints (2, 3)
    println(point1.move(2,3)) // prints ()
    println(point1.toString) // prints (4, 6)

    val p = new AccessModifier()
    println(p.x)
    println(p.y)

    println(p.x_=(201)) // WARNING: Out of bounds
    println(p.y_=(200)) // WARNING: Out of bounds

    val new_x = p.x_=(91)
    val new_y = p.y_=(90)

    println(new_x)
    println(new_y)

  }
}