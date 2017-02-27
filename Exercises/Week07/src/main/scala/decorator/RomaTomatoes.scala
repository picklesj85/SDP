package decorator

class RomaTomatoes(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    newPizza.getDesc + ", Roma Tomatoes (5.20)"
  }

  override def getPrice: Double = {
    newPizza.getPrice + 5.20
  }
}
