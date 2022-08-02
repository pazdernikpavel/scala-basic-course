package udemy

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class, instantiation of abstract class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("HAHAHAHAHA!")
  }

  // this is what happens under the hood
  //
  // class AnonymousClasses$$anon$1 extends Animal {
  //   override def eat: Unit = println("HAHAHAHAHA!")
  // }

  // val funnyAnimal = new AnonymousClasses$$anon$1

  class Person(val name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I Help?")
  }

  // need to pass constructor parameters
  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi it's me!")
  }

  jim.sayHi
  
}
