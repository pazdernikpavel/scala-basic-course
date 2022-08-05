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

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsA = network(personA)
    val friendsB = network(personB)
    network + (personA -> (friendsA + personB)) + (personB -> (friendsB + personA))
  }

  def unfriend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsA = network(personA)
    val friendsB = network(personB)
    network + (personA -> (friendsA - personB)) + (personB -> (friendsB - personA))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)

  val friended = friend(network, "Mary", "Bob")
  println(friended)
  
  val unfriended = unfriend(friended, "Mary", "Bob")
  println(unfriended)

  val removed = remove(friended, "Bob")
  println(removed)


  val people = add(add(add(add(empty, "Bob"), "Mary"), "Jim"), "Lono")
  val jimBob = friend(people, "Jim", "Bob")
  val fullNetwork = friend(jimBob, "Mary", "Bob")

  println(fullNetwork)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!fullNetwork.contains(person)) 0
    else fullNetwork(person).size

  println(nFriends(fullNetwork, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(fullNetwork))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.view.filterKeys(key => network(key).size == 0).toMap.size

  println(nPeopleWithNoFriends(fullNetwork))

  def socialConnection(network: Map[String, Set[String]], personA: String, personB: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(personB, Set(), network(personA) + personA)
  }

  println(socialConnection(fullNetwork, "Mary", "Jim"))
}
