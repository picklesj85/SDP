package factory

class ConcreteRaceCarCreator extends RaceCarCreator{

  override def createRaceCar(raceCarType: String): RaceCar = {
    raceCarType match {
      case "F" => new Ferrari
      case "P" => new Porsche
      case "J" => new Jaguar
    }
  }
}
