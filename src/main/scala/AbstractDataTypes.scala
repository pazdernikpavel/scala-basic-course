package udemy

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch, crunch")
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "croc"
    def eat: Unit = println("nom nom nom")
    def eat(animal: Animal): Unit = println(s"I'm croc and I'm eating ${animal.creatureType}")
  }

  var dog = new Dog
  var croc = new Crocodile

  dog.eat
  croc.eat

  croc.eat(dog)

  // Traits vs Abstract classes
  // 1. multiple traits may be inherited
  // 2. traits = behavior, abstract class = type of thing
  
}
