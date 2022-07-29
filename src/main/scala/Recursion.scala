package udemy

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

    // works
    println(factorial(10))

    // stack overflow
    // println(factorial(50000))

    // TAIL RECURSION
    def anotherFactorial(n: Int): BigInt = {
      @tailrec
      def factorialHelper(x: Int, accumulator: BigInt): BigInt =
        if (x < 1) accumulator
        else factorialHelper(x - 1, x * accumulator)

      factorialHelper(n, 1)
    }

    println(anotherFactorial(50000))

    def anotherFibonacci(n: Int): Int = {
      @tailrec
      def fibonacciHelper(i: Int, last: Int, nextToLast: Int): Int =
        if (i >= n) last
        else fibonacciHelper(i + 1, last + nextToLast, last)

      if (n <= 2) 1
      else fibonacciHelper(2, 1, 1)
    }

    println(anotherFibonacci(8))
}
