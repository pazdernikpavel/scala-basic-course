package udemy

object Generics extends App {

  class MyMap[Key, Value]

  trait MyTrait[Key, Value]

  class MyList[A] {
    // use type A
  }

  val intList = new MyList[Int]
  val stringList = new MyList[String]

  object MyList {
    def empty[A]: MyList[A] = ??? // empty
  }

  val emptyList = MyList.empty[Int]

  // variance problem

  class Animal 
  class Cat extends Animal 
  class Dog extends Animal 

  // yes - list of Cat extends list of Animal = Covariance
  class CovariantList[+A]
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  class CovariantListAcceptingOtherTypes[+A] {
    def add[B >: A](element: B): CovariantListAcceptingOtherTypes[B] = ???
    // A = Cat, B = Dog = Animal
    // Adding a dog into list of cats will turn list of cats into list of generic animals
  }

  // no - invariance, list of animals is not list of cats
  class InvariantList[A]

  // throws error
  // val invariantList: InvariantList[Animal] = new InvariantList[Cat]

  // hell no - contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // trainer of animals can train cat
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal] (animal: A) // accepts only subtypes of Animal
  val cage = new Cage(new Dog)

  // throws error
  // class Car
  // val newCage = new Cage(new Car)
  
}
