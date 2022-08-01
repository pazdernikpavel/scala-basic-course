package udemy

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == this.favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}" // option to use reserved keywords with methods
    def unary_! : String = s"${this.name}, what the heck?!"
    def isAlive = true
    def apply(): String = s"Hi, my name is ${this.name} and I like ${this.favoriteMovie}"
  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)

  val tom = new Person("Tom", "Fight Club")

  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom)) // equivalent

  println(1 + 2)
  println(1.+(2)) // equivalent
  // operators are methods too
  // Akka actors have ? and ! as commands for example

  val x = -1
  val y = 1.unary_- // equivalent
  // unary operators are methods too, works with +, -, ! and ~

  // and can be implemented too
  println(!mary)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)
  // import scala.language.postfixOps
  
  // apply
  println(mary.apply())
  println(mary()) // equivalent


}
