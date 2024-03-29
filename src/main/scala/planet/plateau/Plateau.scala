package planet.plateau

import scala.util.parsing.combinator.RegexParsers

import planet.plateau.Dimension._

class Plateau private[plateau] (val width: Width, val height: Height)

object Plateau extends RegexParsers {

  val width: Parser[Int] = "[0-9]+".r ^^ { _.toInt }
  val height: Parser[Int] = "[0-9]+".r ^^ { _.toInt }

  def expr: Parser[Plateau] = width ~ height ^^ {
    case w ~ h => new Plateau(Width(w), Height(h))
  }
}
