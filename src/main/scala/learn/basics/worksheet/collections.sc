/*
  Arrays are immutable objects
*/

var myArray : Array[String] = new Array[String](10)
// myArray: Array[String] = Array(null, null, null, null, null, null, null, null, null, null)

// The until keyword makes sure to only iterate until myArray.length - 1. Since array element indexes
// go from 0 to the array length - 1, this is the appropriate way to iterate the array.

for(i <- 0 until myArray.length){
  myArray(i) = "some value " + i
}

println(myArray(0))
// some value 0

for(i <- 0 until myArray.length){
  println("i is: " + i);
  println("i'th element is: " + myArray(i))
}

// one more way to iterate Arrays is that
for(myString <- myArray) {
  println(myString)
}



