// if statement
var myInt : Int = 1

var myText : String =
  if(myInt == 0) "myInt == 0"
  else           "myInt != 0"

println(myText)


// while statement
var a : Int = 0

while(a < 10) {
  println("myInt = " + a)
  a += 1
}


// do...while statement
var b : Int = 0

do {
  println("myInt = " + b)
  b+=1
} while(b < 10)


// for statement
var myArray : Array[String] = new Array[String](10);

for(i <- 1 until 10) {
  myArray(i) = "myval is " + i
}

for(value : String <- myArray if value.endsWith("5")) {
  println(value)
  // myval is 5
}

for(value : String <- myArray
    if value.endsWith("5");
    if value.indexOf("val") != 1 ) {

  println(value);
  // myval is 5
}

// multi-dimensional array

/*
  First, an array of arrays is created, and initialized with arrays, and string values.

  Second, the array of arrays is iterated using a nested loop.
  First, each String array is in the array of arrays is assigned to the val anArray.
  Then each String value of each String array is assigned to the value aString.
*/

var myArray1 : Array[Array[String]] = new Array[Array[String]](10)

for(i <- 0 until myArray1.length){
  myArray1(i) = new Array[String](10)

  for(j <- 0 until myArray1(i).length){
    myArray1(i)(j) = "value is: " + i + ", " + j
  }
}

for(anArray : Array[String] <- myArray1;
    aString : String        <- anArray ) {

  println(aString)
}

// old-school method for the prior for loop
for(anArray : Array[String] <- myArray1) {
  for(aString : String <- anArray) {
    println(aString);
  }
}

// Midstream Variable Binding

/*
  The aString.toUpperCase() result is needed by two filter conditions.
  Rather than compute the .toUpperCase() value twice, by nesting them inside each if-statement,
  the uppercase version of aString is computed just once, and assigned to the variable aStringUC.

  The two filter-conditions (if-statements) can now refer to this "mid stream" computed value.
 */


for(anArray : Array[String] <- myArray1;
    aString : String        <- anArray;
    aStringUC = aString.toUpperCase()
    if aStringUC.indexOf("VALUE") != -1;
    if aStringUC.indexOf("5") != -1
) {

  println(aString);
}

// // old-school method for the prior for loop

for(anArray : Array[String] <- myArray1) {
  for(aString : String <- anArray) {

    var aStringUC = aString.toUpperCase();

    if(aStringUC.indexOf("5") != -1 && aStringUC.indexOf("VALUE") != -1){
      println(aString);
    }
  }
}