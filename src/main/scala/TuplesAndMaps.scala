package udemy

object TuplesAndMaps extends App {
  // tuples = finity, ordered "lists"
  val aTuple = new Tuple2(2, "hello scala")
  val bTuple = Tuple2(2, "hello scala")
  val cTuple = (2, "hello scala")

  println(aTuple._1) // 1st element
  println(aTuple._2) // 2nd element
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()
  val phoneBook = Map(("Jim", 555), ("Daniel", 789)).withDefaultValue(-1) // error handling, otherwise exception is thrown
  val phoneBookB = Map("Jim" -> 555, "Daniel" -> 789) // syntactic sugar

  println(phoneBook)

  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim")) // equals
  println(phoneBook("Mary"))

  // add
  val mary = "Mary" -> 678
  val newPhonebook = phoneBook + mary // creates new map, maps are immutable
  println(newPhonebook)

  println(phoneBook.map(pair => pair._1.toLowerCase() -> pair._2))
  println(phoneBook.view.filterKeys(x => x.startsWith("J")).toMap)
  println(phoneBook.view.mapValues(number => number * 10).toMap)

  println(phoneBook.toList)
  println(List("Daniel" -> 555).toMap)
  val names = List("Bob", "James", "Mary", "Michael", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

}
