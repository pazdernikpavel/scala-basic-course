package udemy

import scala.collection.immutable.Stream
import scala.collection.immutable.Stream.{cons, Empty}
object AllThePatterns extends App {

  // 1 - CONSTANTS  
  val x: Any = "scala"
  val constants = x match {
    case 1 => "a number"
    case "scala" => "the scala"
    case true => "the truth"
    case AllThePatterns => "a singleton object"
  }

  // 2 - MATCH ANYTHING
  val matchAnything = x match {
    case _ => 
  }

  // 3 - MATCH VARIABLE
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 4 - TUPLES
  val aTuple = (1, 2)
  val matchTuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"
  }

  println(matchTuple)

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }

  // Pattern matching can be nested

  // 5 - LIST PATTERNS
  val list = List(1,2,3,4)
  list match {
    case List(2, _, _, _) => // extractor pattern
    case List(1, _*) => // list of arbitrary length
    case 1 :: List(_) => // infix pattern
    case List(1,2,3) :+ 42 => // infix pattern
  }

  // 6 - TYPE SPECIFIERS
  val unknown: Any = 2
  unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 - NAME BINDING
  val nameBindingMatch = list match {
    case notEmptyList @ List(_, _) => // you can use notEmptyList later
    case cons(1, rest @ cons(2, _)) => 
  }

  // 8 - MULTIPATTERN
  val multipattern = list match {
    case empty| cons(0, _) => // compound pattern
  }

}
