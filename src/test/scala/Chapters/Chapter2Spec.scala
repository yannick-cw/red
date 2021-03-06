package Chapters

import org.scalatest._

class Chapter2Spec extends FlatSpec with Matchers {
  "fibonacci" should "return the nth fibonacci number" in {
    Chapters.Chapter2.fibonacci(0, 1, 7) shouldEqual 8
  }

  "isSorted" should "return false when the given array is NOT sorted" in {
    Chapters.Chapter2.isSorted(Array(2, 1, 3), isSmaller) shouldEqual false
  }

  "isSorted" should "return true when the given array is sorted" in {
    Chapters.Chapter2.isSorted(Array(1, 2, 3), isSmaller) shouldEqual true
  }

  "isSorted" should "return true when array is empty" in {
    Chapters.Chapter2.isSorted(Array(), isSmaller) shouldEqual true
  }

  "curry" should "should return a curried function with one argument" in {
    def uncurried(a: Int, b: Int):Int = a + b
    val curried = Chapters.Chapter2.curry(uncurried)
    val applied = curried(1)

    applied(2) shouldEqual 3
  }

  "uncurry" should "return a function that needs two arguments" in {
    def curried = (a:Int) => (b: Int) => a + b
    val uncurried = Chapters.Chapter2.uncurry(curried)

    uncurried(1, 2) shouldBe 3
  }

  "compose" should "compose two functions to one" in {
    def first(a: Array[String]): Int = a.length
    def second(a: Int): Int = a + 33
    val composed = Chapters.Chapter2.compose(second, first)

    composed(Array("Hello", "World")) shouldBe 35
  }

  def isSmaller(a: Int, b: Int): Boolean = a < b
}