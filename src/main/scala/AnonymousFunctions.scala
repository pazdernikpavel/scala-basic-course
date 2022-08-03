package udemy

object AnonymousFunctions extends App {
  
  // anonymous functions (LAMBDA)
  val doubler: Int => Int = x => x * 2

  // multiple params
  val adder: (Int, Int) => Int = (a, b) => a + b

  var test = "Test"
  test = 

  // no params
  val doSomething = () => 3

  println(doSomething) // => return function
  println(doSomething()) // => returns actual call
  // use braces when calling lambdas

  // curly brace with lambas
  val stringToInt = {
    (str: String) => str.toInt
  }

  // more syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equals to x => x + 1
  println(niceIncrementer(5))
  val niceAdder: (Int, Int) => Int = _ + _ // equals to (a,b) => a + b

}
