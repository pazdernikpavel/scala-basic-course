package udemy

object HOFsCurries extends App {

  // val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
  // higher order function = HOF

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) return x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // Curried functions

  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y

  println(add3(7))

  // Functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standartFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standartFormat(Math.PI))
  println(preciseFormat(Math.PI))

}
