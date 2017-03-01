package factory

abstract class RaceCar {

  private var topSpeed: Int =  0

  private var name: String = ""

  def setTopSpeed(speed: Int): Unit =  {
    topSpeed = speed
  }

  def setName(name: String): Unit = {
    this.name = name
  }

  def getName: String = {
    name + " Race Car"
  }

  def getTopSpeed: Int = {
    topSpeed
  }

}
