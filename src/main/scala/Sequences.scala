package udemy

import java.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2)) // get by index -> return 3
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello!#" + x))
  (1 until 10).foreach(x => println("Hello!#" + x))

  // Lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList
  println(prepended)
  
  val appended = aList :+ 56
  println(appended)
  
  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-")) // .join equivalent

  // Arrays
  val numbers = Array(1,2,3,4)

  val threeElements = Array.ofDim[Int](3)
  println(threeElements)
  threeElements.foreach(println)

  // mutations
  numbers(2) = 0 // eq. to numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersAsSeq: Seq[Int] = numbers // implicit conversion
  println(numbers)

  // Vectors (immutable seq)
  val aVector: Vector[Int] = Vector(1,2,3)
  println(aVector)

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val random = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(random.nextInt(maxCapacity), random.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val testList = (1 to maxCapacity).toList
  val testVector = (1 to maxCapacity).toVector

  println(getWriteTime(testList))
  println(getWriteTime(testVector))

}
