package udemy

object Exceptions extends App {

  // Exceptions and Error are major throwables.
  // Error => something wrong with JVM
  // Exceptions => reasons in code

  // 1. throw
  val someValue: String = throw new NullPointerException

  // 2. catch
  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("No Int for you!")
    else 42
  }

  val potentialFail = try {
    getInt(true) // throws error
  } catch {
    case ex: RuntimeException => println(ex.getMessage()) 
  } finally {
    // optional
    // does not influence return type of this expression
    println("executes anyway..")
  }

  // 3. define own exceptions
  class MyException extends Exception
  val exception = new MyException
  throw exception
  
}
