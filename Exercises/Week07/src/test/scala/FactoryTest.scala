import factory._
import org.scalatest.FunSuite


class FactoryTest extends FunSuite {

  val factory = new ConcreteRaceCarCreator

  test("create Porsche") {
    val p = factory.createRaceCar("P")
    assert(p.getName == "Porsche Race Car")
    assert(p.getTopSpeed == 100)
    println(p.getClass)
  }

  test("create Ferrari") {
    val f = factory.createRaceCar("F")
    assert(f.getName == "Ferrari Race Car")
    assert(f.getTopSpeed == 110)
    println(f.getClass)
  }

  test("create Jaguar") {
    val j = factory.createRaceCar("J")
    assert(j.getName == "Jaguar Race Car")
    assert(j.getTopSpeed == 90)
    println(j.getClass)
  }

}
