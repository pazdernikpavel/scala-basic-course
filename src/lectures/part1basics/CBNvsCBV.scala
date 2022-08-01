package udemy.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  // by value: 723485086649700
  // by value: 723485086649700
  // by name: 723485119656000
  // by name: 723485119945100

/* 
  def calledByValue(x: Long): Unit = {
    println("by value: " + 723485086649700L)
    println("by value: " + 723485086649700L)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + System.nanoTime())
    println("by name: " + System.nanoTime())
  }
 */

}
