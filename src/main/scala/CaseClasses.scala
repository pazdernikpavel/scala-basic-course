package udemy

object CaseClasses extends App {

  case class Person(name: String, age: Int)
  
  // 1. parameters are promoted to fields
  val jim = new Person("Jim", 31)
  println(jim.age)

  // 2. sensible toString
  println(jim)
  // println(jim) == println(jim.toString()) => syntactic sugar

  // 3. equals and hashCode implemented
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. handy copy method
  val jim3 = jim.copy(age = 35)
  println(jim3)

  // 5. have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // apply method

  // 6. serializable
  // Akka

  // 7. extractor patterns

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  
}
