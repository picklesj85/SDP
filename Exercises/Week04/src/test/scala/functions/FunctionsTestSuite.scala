package functions

import functions.Funcs._
import org.scalatest.FunSuite

class FunctionsTestSuite extends FunSuite {
  // Basics
  test("Tail removes the first element") {
    assert(tail(List(1, 2, 3, 4)) == List(2, 3, 4))
  }

  test("Tail throws IllegalArgumentException on empty list") {
    assertThrows[IllegalArgumentException] {
      tail(List())
    }
  }

  test("setHead changes the first element of the list") {
    assert(setHead(List("A", "B", "C"), "0") == List("0", "B", "C"))
  }

  test("setHead on empty list creates single element list") {
    assert(setHead(List(), "0") == List("0"))
  }

  test("drop removes N elements from the front of the list") {
    assert(drop(List(1, 2, 3), 2) == List(3))
  }

  test("drop returns empty list when n is bigger than list size") {
    assert(drop(List(1, 2, 3), 4) == List())
  }

  test("drop returns empty list when n equals list size") {
    assert(drop(List(1, 2), 2) == List())
  }

  test("init removes the last element") {
    assert(init(List("A", "B", "C", "D")) == List("A", "B", "C"))
  }

  test("init throws IllegalArgumentException on empty list") {
    assertThrows[IllegalArgumentException] {
      init(List())
    }
  }

  test("init returns empty list on list of one element") {
    assert(init(List("0")) == List())
  }


  // Folding
  test("foldLeft computes the correct value") {
    assert(foldLeft(List("H", "e", "l", "l", "o"), "")(_ + _) == "Hello")
  }

  test("foldLeft adds int") {
    assert(foldLeft(List(1, 2, 3, 4, 5), 0)(_ + _) == 15)
  }

  test("foldLeft produces correct result when applied on empty list") {
    assert(foldLeft(List[Int](), 0)(_ + _) == 0)
  }

  test("sum produces the correct sum") {
    assert(sum(List(1.0, 2.0, 3.0, -3.0, -2.0, -1.0)) == 0.0)
  }

  test("sum on empty list") {
    assert(sum(List()) == 0.0)
  }

  test("product produces the correct product") {
    assert(product(List(1.0, 2.0, 3.0, 4.0, 5.0)) == 120.0)
  }

  test("product on empty list") {
    assert(product(List()) == 0.0)
  }

  test("length calculates the length") {
    assert(length("Hello".toList) == 5)
  }

  test("length on empty list") {
    assert(length(List()) == 0)
  }

  test("reverse reverses the list") {
    assert(reverse("Hello".toList) == "olleH".toList)
  }

  test("reverse on empty list") {
    assert(reverse(List()) == List())
  }

  test("flatten flattens the nested list") {
    assert(flatten(List(List(1, 2, 3), List(4, 5, 6))) == List(1, 2, 3, 4, 5, 6))
  }

  test("flatten on a part empty nested list") {
    assert(flatten(List(List(), List(1, 2, 3))) == List(1, 2, 3))
  }

  test("flatten on nested lists all empty") {
    assert(flatten(List(List(), List(), List())) == List())
  }

  // Map and Filter
  test("map creates a new list of the correct values") {
    assert(map((1 to 10).toList)(_ + 1) == (2 to 11).toList)
  }

  test("map on empty list") {
    assert(map(List())(_.toString) == List())
  }

  test("filter filters the list") {
    assert(filter((-5 to 5).toList)(_ > 0) == (1 to 5).toList)
  }

  test("filter on empty list") {
    assert(filter(List())(x => x) == List())
  }

  test("filter where none true") {
    assert(filter(List(2, 4, 6, 8))(x => x % 2 != 0) == List())
  }

  test("filter all true") {
    assert(filter(List(2, 4, 6, 8))(x => x % 2 == 0) == List(2, 4, 6, 8))
  }

  test("flatMap maps and flattens") {
    assert(flatMap((1 to 5).toList)(x => (x to 5).toList) ==
      List(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5))
  }

  test("flatMap on empty list") {
    assert(flatMap(List[Int]())(x => (x to 5).toList) == List())
  }

  // Combined

  test("maxAverage calculates the max average") {
    val list = List(1.0, 2.0, 3.0, 4.0, 5.0).map(x => (x, x + 10))
    assert(maxAverage(list) == 13.0)
  }

  test("variance calculates the correct variance") {
    val v = variance(List(1.0, 2.0, 3.0, 4.0, 5.0))
    assert(v == 2.0, "If you got 2.5, you divided by the wrong thing, probably.")
  }
}
