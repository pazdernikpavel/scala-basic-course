package udemy.part1basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  val equals = x == 3
  println(equals)
  
  val test = 10 / 2
  println(test)

  var variable = 2
  variable += 3
  println(variable == 5)

  val condition = if (true) 7 else 4
  println(condition)

}
