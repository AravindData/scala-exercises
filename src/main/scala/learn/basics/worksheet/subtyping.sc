/*
  One type can be a subtype of another, in which case you can use the subtype in any
  place that the supertype is needed
 */

List(5,true)
// res0: List[AnyVal] = List(5, true)
// The standard implementation includes nine AnyVal subtypes:
// scala.Double, scala.Float, scala.Long, scala.Int, scala.Char, scala.Short, and scala.Byte are the numeric value types.

// Image attached : google-drive data-engineering/docs/scala-learning