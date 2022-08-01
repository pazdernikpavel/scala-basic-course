package udemy

object Inheritance extends App {

  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom") // could be protected, private
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunchy crunch")
    }
  }

  var cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // prevent overrides => keyword final

}
