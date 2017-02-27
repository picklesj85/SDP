package decorator

class GreenOlives(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    newPizza.getDesc + ", Green Olives (5.47)"
  }

  override def getPrice: Double = {
    newPizza.getPrice + 5.47
  }
}
