package udemy

import scala.util.{Success, Failure, Try}

object HandlingExceptions extends App {

  // create success and failure explicitely
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("super failure"))
  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("no string for you")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)
  
  // syntax sugar
  val anotherPotentialFailure = Try {
    unsafeMethod()
  }
  println(anotherPotentialFailure)
  
  println(anotherPotentialFailure.isSuccess)
  println(anotherPotentialFailure.isFailure)
  
  def backupMethod(): String = "valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)
  
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("here I am")
  val betterResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterResult)
}
