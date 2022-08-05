package udemy

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  def unsafeMethod(): String = null
  // val result = Some(null) // WRONG
  val result = Option(unsafeMethod()) // Some or None
  println(result)
  
  def backupMethod(): String = "valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)

  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("better backup")
  val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterChainedResult)

  // map, flatMap, filter
  println(myFirstOption.isEmpty)
  println(myFirstOption.isDefined)
  println(myFirstOption.get) // UNSAFE - do not use
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10)) // turns Some into None
  println(myFirstOption.flatMap(x => Option(x * 10)))
  
}
