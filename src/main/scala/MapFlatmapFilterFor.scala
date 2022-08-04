package udemy

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combinations between 3 lists
  val numbers = List(1,2,3,4)
  val colors = List("black", "white")
  val characters = List('a', 'b', 'c', 'd')

  val addColor = (x: String) => {
    colors.map(x + " " + _)
  }

  val addNumber = (x: Char) => {
    val charAsString = x.toString
    numbers.flatMap(charAsString + _)
  }

  // "iterating"
  println(characters.flatMap(char => numbers.flatMap(num => colors.map(color => "" + char + num + color))))

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // if guard
    char <- characters
    color <- colors
  } yield "" + char + n + color

  println(forCombinations)
  // for combinations prefered over nested flat maps

  for {
    n <- numbers
  } yield println(n)
  // equals to list.foreach(println)

  // syntax overload
  list.map { x =>
    x * 2
  }

  val just3 = Just(3)
  println(just3) // Just(3)
  println(just3.map(_ * 2)) // Just(6)
  println(just3.flatMap(x => Just(x % 2 == 0))) // Just(false)
  println(just3.filter(_ % 2 == 0)) // MaybeNot
  
}

abstract class Maybe[+T] {
  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
  def filter(p: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {
  def map[B](f: Nothing => B): Maybe[B] = MaybeNot
  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
  def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {
  def map[B](f: T => B): Maybe[B] = Just(f(value))
  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)
  def filter(p: T => Boolean): Maybe[T] =
    if (p(value)) this
    else MaybeNot
}
