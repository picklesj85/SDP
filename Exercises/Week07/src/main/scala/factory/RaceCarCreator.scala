package factory

trait RaceCarCreator {

  def createRaceCar(raceCarType: String): RaceCar
}