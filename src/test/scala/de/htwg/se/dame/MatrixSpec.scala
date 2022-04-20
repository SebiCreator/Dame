package de.htwg.se.dame

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class MatrixSpec extends AnyWordSpec with Matchers {
  "A Matrix " should {
    val matrix = new Matrix[String](6, "O", "X")
    println("matrix111")

    val matrix_default = new Matrix[String]()
  }
}
