import scala.concurrent.Future
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

val firstOccurrence: Future[Int] = Future {
  val source = scala.io.Source.fromFile("myText.txt")
  source.toSeq.indexOfSlice("myKeyword")
}

firstOccurrence onComplete {
  case Success(i) => println(i)
  case Failure(e) => println("An error has occured: " + e)
}

// (Since version 2.12.0) onSuccess & onFailure has deprecated


----------------------------------------------------------------------------------


import scala.concurrent.Future
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

val firstOccurrence: Future[Int] = Future {
  val source = scala.io.Source.fromFile("myText.txt")
  source.toSeq.indexOfSlice("myKeyword")
}

firstOccurrence map { first => 
  println(first)
}


----------------------------------------------------------------------------------

import scala.concurrent.Future
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

val first: Future[Int] = Future {
  val source = scala.io.Source.fromFile("myText1.txt")
  source.toSeq.indexOfSlice("myKeyword")
}

val second: Future[Int] = Future {
  val source = scala.io.Source.fromFile("myText2.txt")
  source.toSeq.indexOfSlice("myKeyword")
}

val purchase = for {
  f <- first
  s <- second
} yield println(s)

purchase ....
