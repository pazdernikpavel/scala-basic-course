package udemy

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  person.greet("Pavel")
  person.greet()

  val author = new Writer("Martin", "L. King", 45)
  println(author.getFullName())

  val novel = new Novel("The Autobiography", 1960, author)
  println(novel.authorAge())
  println(novel.writtenBy())

  val newRelease = novel.copy(2020)

  println(novel.yearOfRelease)
  println(newRelease.yearOfRelease)

}

// constructor
// parameters not fields, use val/var to do that
class Person(name: String, val age: Int = 0) {

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")

  // overloading
  def greet(): Unit = println(s"${this.name} says: Hi, fellow traveler!")

  // multiple constructors
  def this(name: String) = this(name, 18)
  def this() = this("John Doe")

}

class Writer(firstName: String, surname: String, val age: Int) {
  def getFullName(): String = s"${this.firstName} ${this.surname}"
}


class Novel(name: String, val yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = this.author.age
  def writtenBy(): String = this.author.getFullName()
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}
