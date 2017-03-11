package builder


case class CarDirector(carBuilder: CarBuilder) {
  def build = {
    carBuilder.buildBodyStyle
    carBuilder.buildBreaks
    carBuilder.buildEngine
    carBuilder.buildFuelType
    carBuilder.buildPower
    carBuilder.buildSeats
    carBuilder.buildWindows
  }

}
