/*
  Tuples are immutable.
*/

val ingredient = ("Sugar" , 25):Tuple2[String, Int]

/*
  Accessing tuple variable
 */

println(ingredient._1) // Sugar
println(ingredient._2) // 25

/*
  Deconstructing tuple data
 */

val (name, quantity) = ingredient

println(name)      // Sugar
println(quantity)  // 25

/*
  Deconstructing tuple data using pattern matching
 */

val planetDistanceFromSun = List( ("Mercury", 57.9), ("Venus", 108.2),
                                  ("Earth", 149.6 ), ("Mars", 227.9),
                                  ("Jupiter", 778.3) )

planetDistanceFromSun.foreach{ tuple => {

  tuple match {

    case ("Mercury", distance) => println(s"Mercury is $distance millions km far from Sun")
    case p if(p._1 == "Venus") => println(s"Venus is ${p._2} millions km far from Sun")
    case p if(p._1 == "Earth") => println(s"Blue planet is ${p._2} millions km far from Sun")
    case _ => println("Too far....")

            }
    }
}



val numPairs = List((2, 5), (3, -7), (20, 56))

for ((a, b) <- numPairs) {
  println(a * b)
}


