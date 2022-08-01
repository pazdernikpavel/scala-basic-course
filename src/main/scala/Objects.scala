package udemy

object Objects extends App {

  // does not have static access modifiers
  object Person { // "static" level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    def apply(mother: Person, father: Person): Person = new Person
  }

  class Person { // instance-level functionality
  }

  // using both is called companions

  println(Person.N_EYES)
  println(Person.canFly)

  // scala object is singleton
  // its type + its only instance
  val mary = new Person
  val john = new Person
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val timy = Person(mary, john) // calling Apply function

}
