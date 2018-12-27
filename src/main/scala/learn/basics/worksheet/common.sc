/*
  foldLeft(n) -> n represents the initial value to the fold
  if 0 the returned value is 55
  if 10 the returned value is 65
 */
val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val res = numbers.foldLeft(0)((m, n) => m + n)
print(res) // 55

/*
  The _ ("underscore character")
*/

val salaries = Seq(20000, 70000, 40000)

val doubleSalary = (x: Int) => x * 2
val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)

// The above two lines can be simplified by using map function
val newSalaries1 = salaries.map(x => x * 2) // List(40000, 140000, 80000)

// More simplification using underscore
val newSalaries2 = salaries.map(_ * 2)

