package udemy

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)
  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is a charm"
    case _ => "something else" // _ = wildcard
  }

  println(x)
  println(description)

  // decomposed values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I am can't drink in the USA" // guard with if
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "I don't know who I am"
  }

  println(greeting)

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  val animalMatch = animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed.")
    case _ => println("Non-matching animal :(")
  }
}
