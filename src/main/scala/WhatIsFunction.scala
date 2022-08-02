package udemy

object WhatIsFunction extends App {

  // Goal is to use functions as first class elements
  // Problem is OOP



  abstract class MyFunction[A, B] {
    def apply(element: A): B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types supported by Scala
  // Function1[A, B]

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt 
  }

  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Can be also written like
  // new Function2[A, B, R] => (A, B) => R

  // All scala functions are objects

  val concatString: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

}
